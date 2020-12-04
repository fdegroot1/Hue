package com.example.philipshuestudent.service.impl;

import android.util.Log;

import com.example.philipshuestudent.model.Lamp;
import com.example.philipshuestudent.model.Product;
import com.example.philipshuestudent.service.HueEmulatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HueEmulatorServiceImpl implements HueEmulatorService {

    private static final String TAG = HueEmulatorServiceImpl.class.getSimpleName();

    private OkHttpClient    client       =   new OkHttpClient();
    private String          bridgeUri    =   "http://localhost:8000/api/";
    private String          username     =   "newdeveloper";
    private String          category     =   "/lights";

    @Override
    public Lamp getLights() {
        //Make the uri immutable
        final String uri = bridgeUri+username+category;

        //keep mutable as it overwrites the result
        Lamp lamp;
        //Create request
        final Request allLightsRequest = new Request.Builder().url(uri).build();

        try (Response response = client.newCall(allLightsRequest).execute()){
            // Im using FasterXML Jackson to map JSON
            lamp = new ObjectMapper().readValue(response.body().string(), Lamp.class);
        } catch (IOException e) {
            Log.d(TAG, e.getLocalizedMessage());
            lamp = new Lamp();
        }

        return lamp;
    }

    public void setBridgeUri(String bridgeUri) {
        this.bridgeUri = bridgeUri;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
