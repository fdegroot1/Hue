package com.example.philipshuestudent.service.impl;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.philipshuestudent.model.Lamp;
import com.example.philipshuestudent.service.ApiListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import okhttp3.OkHttpClient;

public class ApiManager {

    private static final String TAG = ApiManager.class.getSimpleName();

    private OkHttpClient    client       =   new OkHttpClient();
    private String          bridgeUri    =   "http://localhost:8000/api/";
    private String          username     =   "newdeveloper";
    private String          category     =   "/lights";
    private RequestQueue queue;
    private ApiListener apiListener;

    public ApiManager(Context context, ApiListener apiListener) {
        this.queue = Volley.newRequestQueue(context);
    }

    public Lamp getLights() {
        //Make the uri immutable
        final String uri = bridgeUri+username+category;

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, uri, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    for (Iterator<String> it = response.keys(); it.hasNext(); ) {
                        String key = it.next();
                        JSONObject jsonObject = response.getJSONObject(key);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return null;
    }

    public void setBridgeUri(String bridgeUri) {
        this.bridgeUri = bridgeUri;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
