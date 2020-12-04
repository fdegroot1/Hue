package com.example.philipshuestudent.service;

import com.example.philipshuestudent.model.Lamp;

public interface ApiListener {
    public void onAvailable(Lamp lamp);
    public void onError(Lamp lamp);
}
