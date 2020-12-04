package com.example.philipshuestudent.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Pointsymbol implements Serializable {

    private ArrayList<String> list;

    public Pointsymbol(JSONObject object) {
        list = new ArrayList<>();
        for (Iterator<String> it = object.keys(); it.hasNext(); ) {
            String key = it.next();
            try {
                list.add(object.getString(key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
