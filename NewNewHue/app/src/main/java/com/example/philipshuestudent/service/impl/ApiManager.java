package com.example.philipshuestudent.service.impl;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.philipshuestudent.model.Lamp;
import com.example.philipshuestudent.service.ApiListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;


public class ApiManager {

//    private static ApiManager manager;
//
//    public static ApiManager getInstance() {
//        return manager;
//    }
//
//    public static ApiManager createInstance(Context context, ApiListener apiListener) {
//        manager = new ApiManager(context, apiListener);
//        return manager;
//    }

    private static final String TAG = ApiManager.class.getSimpleName();

    private String bridgeUri = "https://192.168.178.172:8000/api/";
    private String username = "newdeveloper";
    private String category = "/lights";
    private RequestQueue queue;
    private ApiListener listener;

    public ApiManager(Context context, ApiListener apiListener) {
        Log.d(this.getClass().getName(), " Create manager");
        this.queue = Volley.newRequestQueue(context);
        this.listener = apiListener;
    }

    public void getLights() {
        final String uri = bridgeUri + username + category;

        Log.d(this.getClass().getName(), " Get lights");
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, uri, null, response -> {
            try {

                Log.d(this.getClass().getName(), "Test: " + response.keys().toString());
                for (Iterator<String> it = response.keys(); it.hasNext(); ) {
                    String key = it.next();
                    Lamp lamp = new Lamp(response.getJSONObject(key));
                    listener.onAvailable(lamp);
                    Log.d(ApiManager.class.getName(), "Lamp: " + lamp.getName());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Log.d(this.getClass().getName(), "ERRRRRRRROR");
            error.printStackTrace();
            listener.onError(new Error(error.getLocalizedMessage()));
        });
        this.queue.add(request);
    }

    public void sendPost(int lampNr, JSONObject body) {
        final String url = bridgeUri + username + category + "/" + lampNr;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, body, response -> {
            Log.d(getClass().getName(), "Message correct");
        }, error -> {
            error.printStackTrace();
            Log.d(getClass().getName(), error.getMessage());
        });
        queue.add(request);
    }

    public void setColor(int lampNr, int color) {

    }

    public void setBridgeUri(String bridgeUri) {
        this.bridgeUri = bridgeUri;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
