
package com.example.philipshuestudent.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class State {

    private double[] xy;
    private int  ct;
    private String alert;
    private int sat;
    private int bri;
    private int hue;
    private String colormode;
    private boolean reachable;
    private boolean on;

    public State(JSONObject object) {
        try {
            JSONArray list = object.getJSONArray("xy");
            this.xy = new double[2];
            this.xy[0] = list.getDouble(0);
            this.xy[1] = list.getDouble(1);
            this.ct = object.getInt("ct");
            this.alert = object.getString("alert");
            this.sat = object.getInt("sat");
            this.bri = object.getInt("bri");
            this.hue = object.getInt("hue");
            this.colormode = object.getString("colormode");
            this.reachable = object.getBoolean("reachable");
            this.on = object.getBoolean("on");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public double[] getXy() {
        return xy;
    }

    public int getCt() {
        return ct;
    }

    public String getAlert() {
        return alert;
    }

    public int getSat() {
        return sat;
    }

    public int getBri() {
        return bri;
    }

    public int getHue() {
        return hue;
    }

    public String getColormode() {
        return colormode;
    }

    public boolean isReachable() {
        return reachable;
    }

    public boolean isOn() {
        return on;
    }
}
