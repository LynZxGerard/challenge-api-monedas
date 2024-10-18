package com.alurachallenge.ui;

import com.alurachallenge.logic.Moneda;
import com.alurachallenge.logic.RegistrosDeLogs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Principal extends Application {

    private static final Map<String, Moneda> monedaMap = new HashMap<>();
    private TextField cantidadField;
    private ComboBox<Moneda> monedaBaseComboBox;
    private ComboBox<Moneda> monedaDestinoComboBox;
    private Label resultadoLabel;
    private Gson gson;

    @Override
    public void start(Stage primaryStage) {
        gson = new GsonBuilder().setPrettyPrinting().create();

        // Inicializar las monedas
        inicializarMonedas();

        // Crear de la interfaz
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: #f0f8ff;");  // Fondo color azul claro

        // Estilo de la fuente
        String fontStyle = "-fx-font-family: 'Arial'; -fx-font-size: 14px; -fx-font-weight: bold;";

        // Combobox de monedas base y destino
        monedaBaseComboBox = new ComboBox<>();
        monedaBaseComboBox.getItems().addAll(monedaMap.values());
        monedaBaseComboBox.setStyle("-fx-font-size: 14px; -fx-background-color: #bde2ff;");  // Fondo claro

        monedaDestinoComboBox = new ComboBox<>();
        monedaDestinoComboBox.getItems().addAll(monedaMap.values());
        monedaDestinoComboBox.setStyle("-fx-font-size: 14px; -fx-background-color: #bde2ff;");

        // Campo de texto para cantidad
        cantidadField = new TextField();
        cantidadField.setPromptText("Ingrese cantidad");
        cantidadField.setStyle(fontStyle + " -fx-border-color: #4682b4; -fx-border-radius: 5px;");

        // Botón para convertir
        Button convertirButton = new Button("Convertir");
        convertirButton.setOnAction(e -> convertir());
        convertirButton.setStyle("-fx-background-color: #4682b4; -fx-text-fill: white; " + fontStyle);

        // Etiqueta para mostrar el resultado
        resultadoLabel = new Label();
        resultadoLabel.setStyle(fontStyle);

        // Añadir los elementos al GridPane
        gridPane.add(new Label("Moneda Base:"), 0, 0);
        gridPane.add(monedaBaseComboBox, 1, 0);
        gridPane.add(new Label("Moneda Destino:"), 0, 1);
        gridPane.add(monedaDestinoComboBox, 1, 1);
        gridPane.add(new Label("Cantidad:"), 0, 2);
        gridPane.add(cantidadField, 1, 2);
        gridPane.add(convertirButton, 0, 3);
        gridPane.add(resultadoLabel, 1, 3);

        // Ajustar el tamaño de la ventana
        Scene scene = new Scene(gridPane, 580, 180);
        primaryStage.setTitle("Conversor de Monedas");
        primaryStage.setScene(scene);

        primaryStage.show(); // Graficar
    }

    private void convertir() {

        // Validar que todos los campos de la interfaz sean validos
        try {
            double cantidad = Double.parseDouble(cantidadField.getText());

            if (cantidad < 0) {
                throw new NumberFormatException("La cantidad no puede ser negativa");
            }

            Moneda baseCurrency = monedaBaseComboBox.getValue();
            Moneda targetCurrency = monedaDestinoComboBox.getValue();

            if (baseCurrency != null && targetCurrency != null) {

                double tipoDeCambio = baseCurrency.convertirA(targetCurrency);

                if (tipoDeCambio != -1) {
                    double resultado = cantidad * tipoDeCambio;
                    resultadoLabel.setText(String.format("%.2f en %s equivalen a %.2f en %s",
                            cantidad, baseCurrency.getNombre(), resultado, targetCurrency.getNombre()));

                    // Guardar el log de la conversión
                    RegistrosDeLogs.guardarLog(gson, cantidad, baseCurrency, targetCurrency, resultado);
                } else {
                    resultadoLabel.setText("No se pudo obtener el tipo de cambio.");
                }
            } else {
                resultadoLabel.setText("Seleccione ambas monedas.");
            }

        } catch (NumberFormatException e) {
            resultadoLabel.setText("Entrada no válida. Ingrese un número positivo.");
        }
    }

    private void inicializarMonedas() {
        // Añadir las monedas a usar en la interfaz
        monedaMap.put("MXN", new Moneda("MXN", "Peso Mexicano"));
        monedaMap.put("EUR", new Moneda("EUR", "Euro"));
        monedaMap.put("GBP", new Moneda("GBP", "Libra"));
        monedaMap.put("USD", new Moneda("USD", "Dólar USA"));
        monedaMap.put("HKD", new Moneda("HKD", "Dólar HK"));
        monedaMap.put("NZD", new Moneda("NZD", "Dólar NZ"));
        monedaMap.put("CAD", new Moneda("CAD", "Dólar CAN"));
        monedaMap.put("AUD", new Moneda("AUD", "Dólar AUS"));
        monedaMap.put("JPY", new Moneda("JPY", "Yen Japonés"));
        monedaMap.put("CHF", new Moneda("CHF", "Franco Suizo"));
        monedaMap.put("CNY", new Moneda("CNY", "Yuan Chino"));
        monedaMap.put("BRL", new Moneda("BRL", "Real BR"));
        monedaMap.put("INR", new Moneda("INR", "Rupia India"));
        monedaMap.put("RUB", new Moneda("RUB", "Rublo Ruso"));
        monedaMap.put("ZAR", new Moneda("ZAR", "Rand"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
