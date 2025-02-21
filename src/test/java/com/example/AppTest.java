package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testHome() {
        App app = new App();
        String result = app.home();
        assertEquals("index", result);  // Updated expected output
    }
}
