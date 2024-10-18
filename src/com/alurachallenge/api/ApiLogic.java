package com.alurachallenge.api;

import com.alurachallenge.logic.RespuestaTasaDeCambio;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiLogic {
    private String apiKey; // Usar su propia Key

    // Constructor
    public ApiLogic(String apiKey) {
        this.apiKey = apiKey;
    }

    public double consultarTipoDeCambio(String baseCurrency, String targetCurrency) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Consulta a la API usando la moneda base seleccionada
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Usar Gson para convertir la respuesta JSON en un objeto de Java
            Gson gson = new Gson();
            RespuestaTasaDeCambio exchangeResponse = gson.fromJson(response.body(), RespuestaTasaDeCambio.class);

            // Verificar si la respuesta de la API fue exitosa
            if (exchangeResponse.getResult().equals("success")) {
                // Obtener el tipo de cambio hacia la moneda de destino
                return exchangeResponse.getConversionRates().get(targetCurrency);
            } else {
                System.out.println("Error: La API no devolvió éxito.");
                return -1;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
            return -1;
        }
    }
}
