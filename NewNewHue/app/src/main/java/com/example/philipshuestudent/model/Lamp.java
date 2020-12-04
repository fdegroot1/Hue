
package com.example.philipshuestudent.model;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Lamp implements Serializable {

    private String modelID;
    private String name;
    private String swversion;
    private State state;
    private String type;
    private Pointsymbol pointSymbol;
    private String uniqueid;
    private int lampnummer;

    public Lamp(JSONObject object) {

        try {
            this.modelID = object.getString("modelid");
            this.name = object.getString("name");
            this.lampnummer = Character.getNumericValue(name.charAt(name.length() - 1));
            this.swversion = object.getString("swversion");
            this.state = new State(object.getJSONObject("state"));
            this.type = object.getString("type");
            this.pointSymbol = new Pointsymbol(object.getJSONObject("pointsymbol"));
            this.uniqueid = object.getString("uniqueid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getModelID() {
        return modelID;
    }

    public String getName() {
        return name;
    }

    public int getLampnummer() {
        return lampnummer;
    }

    public String getSwversion() {
        return swversion;
    }

    public State getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public Pointsymbol getPointSymbol() {
        return pointSymbol;
    }

    public String getUniqueid() {
        return uniqueid;
    }
}
