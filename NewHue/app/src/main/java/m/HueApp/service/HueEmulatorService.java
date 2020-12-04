package m.HueApp.service;

import m.HueApp.model.Lamp;

public interface HueEmulatorService {
    Lamp getLights();
    void setBridgeUri(String uri);
    void setUsername(String username);
}
