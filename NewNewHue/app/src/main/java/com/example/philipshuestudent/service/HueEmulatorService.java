package com.example.philipshuestudent.service;

import com.example.philipshuestudent.model.Lamp;

public interface HueEmulatorService {
    Lamp getLights();
    void setBridgeUri(String uri);
    void setUsername(String username);
}
