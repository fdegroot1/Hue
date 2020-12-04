package com.example.philipshuestudent.service.impl;

import com.example.philipshuestudent.model.Lamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiListenerImplTest {

    private ApiManager sut = new ApiManager();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getLights() {
        Lamp lights = sut.getLights();
        assertTrue(lights.getProduct() != null );
    }
}