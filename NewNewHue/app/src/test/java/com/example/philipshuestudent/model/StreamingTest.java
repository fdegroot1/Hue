package com.example.philipshuestudent.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamingTest {

    private Streaming streaming = new Streaming();

    @DisplayName("Test of value for renderer is set correctly")
    @Test
    void test_streaming_renderer() {
        streaming = new Streaming();
        streaming.setRenderer(true);
        assertTrue(streaming.getRenderer());
    }

    @Test
    void test_streaming_proxy() {
        streaming = new Streaming();
        streaming.setProxy(true);
        assertTrue(streaming.getProxy());
    }

    @Test
    void test_streaming_additional_property() {
        streaming = new Streaming();
        streaming.setAdditionalProperty("Test", 19);
        assertEquals(19, streaming.getAdditionalProperties().get("Test"));
    }
}