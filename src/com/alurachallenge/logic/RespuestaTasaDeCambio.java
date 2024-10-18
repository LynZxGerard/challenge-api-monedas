package com.alurachallenge.logic;
import java.util.Map;

public class RespuestaTasaDeCambio {

    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Getters
    public String getResult() {
        return result;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

}
