package com.example.philipshuestudent.service.impl;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.philipshuestudent.model.Lamp;
import com.example.philipshuestudent.service.ApiListener;

import org.json.JSONException;

import java.util.Iterator;


public class ApiManager {

    private static final String TAG = ApiManager.class.getSimpleName();

    private String bridgeUri = "http://localhost:8000/api/";
    private String username = "newdeveloper";
    private String category = "/lights";
    private RequestQueue queue;
    private ApiListener listener;

    public ApiManager(Context context, ApiListener apiListener) {
        this.queue = Volley.newRequestQueue(context);
        this.listener = apiListener;
    }

    public void getLights() {
        final String uri = bridgeUri + username + category;

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, uri, null, response -> {
            try {
                for (Iterator<String> it = response.keys(); it.hasNext(); ) {
                    String key = it.next();
                    Lamp lamp = new Lamp(response.getJSONObject(key));
                    listener.onAvailable(lamp);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            listener.onError(new Error( error.getLocalizedMessage()));
        });
        this.queue.add(request);
    }

    public void setBridgeUri(String bridgeUri) {
        this.bridgeUri = bridgeUri;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
