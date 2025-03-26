package com.gerencia;

public class Vizinho {
    private String capital;
    private float distancia;

    public Vizinho(String capital, float distancia) {
        this.capital = capital;
        this.distancia = distancia;
    }

    public String getCapital() {
        return capital;
    }

    public float getDistancia() {
        return distancia;
    }

}