package com.alurachallenge.ignore;

import com.alurachallenge.api.ApiLogic;

public class ApiCredentials {
    private static final String API_KEY = "cc9317c803353f37adcfce1c"; // Privada

    public static ApiLogic createApiCredentials() {
        return new ApiLogic(API_KEY);
    }
}
