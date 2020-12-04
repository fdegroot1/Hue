package com.example.philipshuestudent.service.impl;

import com.example.philipshuestudent.model.Lamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HueEmulatorServiceImplTest {

    private HueEmulatorServiceImpl sut = new HueEmulatorServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getLights() {
        Lamp lights = sut.getLights();
        assertTrue(lights.getProduct() != null );
    }
}