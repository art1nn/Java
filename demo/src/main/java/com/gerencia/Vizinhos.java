package com.gerencia;

import java.util.LinkedList;

public class Vizinhos {
    private LinkedList<Vizinho> listaVizinhos = new LinkedList<>();

    public void settar_vizinho(String capital, float distancia) {
        listaVizinhos.add(new Vizinho(capital, distancia));
    }

    public LinkedList<Vizinho> getListaVizinhos() {
        return listaVizinhos;
    }
}