package com.alurachallenge.logic;

import com.alurachallenge.api.ApiLogic;
import com.alurachallenge.ignore.ApiCredentials;

public class Moneda {
    private String codigo;
    private String nombre;

    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    // Nuevo método para convertir la moneda
    public double convertirA(Moneda destino) {
        ApiLogic api = ApiCredentials.createApiCredentials();
        return api.consultarTipoDeCambio(this.getCodigo(), destino.getCodigo());
    }

    @Override
    public String toString() {
        return nombre; // Para que se muestren bien las opciones en el Combobox
    }
}