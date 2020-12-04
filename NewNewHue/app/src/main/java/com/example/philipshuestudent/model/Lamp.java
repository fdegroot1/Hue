
package com.example.philipshuestudent.model;


import org.json.JSONException;
import org.json.JSONObject;

public class Lamp {

    private String modelID;
    private String name;
    private String swversion;
    private State state;
    private String type;
    private Pointsymbol pointSymbol;
    private String uniqueid;

    public Lamp(JSONObject object) {

        try {
           this.modelID = object.getString("modelid");
           this.name = object.getString("name");
           this.swversion = object.getString("swversion");
           this.state = new State(object.getJSONObject("state"));
           this.type = object.getString("type");
           this.pointSymbol = new Pointsymbol(object.getJSONObject("pointsymbol"));
           this.uniqueid = object.getString("uniqueid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
