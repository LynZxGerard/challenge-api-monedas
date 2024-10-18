package com.alurachallenge.logic;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrosDeLogs {
    private static final String LOG_FILE = "conversiones.json";

    public static void guardarLog(Gson gson, double cantidad, Moneda baseCurrency, Moneda targetCurrency, double resultado) {
        LogConversion log = new LogConversion(cantidad, baseCurrency.getCodigo(), targetCurrency.getCodigo(), resultado);

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {

            // Escribir el log en formato JSON
            writer.write(gson.toJson(log) + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error al guardar el log: " + e.getMessage());
        }
    }

    // Clase para el log de conversiones
    private static class LogConversion {
        private final double cantidad;
        private final String monedaBase;
        private final String monedaDestino;
        private final double resultado;

        //Solo guardar en el log los parametros de la API que se usaron en la consulta
        public LogConversion(double cantidad, String monedaBase, String monedaDestino, double resultado) {
            this.cantidad = cantidad;
            this.monedaBase = monedaBase;
            this.monedaDestino = monedaDestino;
            this.resultado = resultado;
        }
    }
}
