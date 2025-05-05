package com.gerencia;

public class Vizinho {

    private Capital capital;
    private Double distancia;

    public Vizinho(Capital capital, Double distancia) {
        this.capital = capital;
        this.distancia = distancia;
    }

    public Capital getCapital() {
        return capital;
    }

    public Double getDistancia() {
        return distancia;
    }

}