package com.gerencia;

import java.util.LinkedList;

public class Vizinhos {
    private LinkedList<Vizinho> listaVizinhos = new LinkedList<>();


    private void set_vizinho(Capital capital, Double distancia){
        this.listaVizinhos.add(new Vizinho(capital, distancia));
    }

    public void settar_vizinho(Capital atual, Capital capital, Double distancia) {
        this.set_vizinho(capital, distancia);
        capital.getVizinhos().set_vizinho(atual, distancia);
    }

    public LinkedList<Vizinho> getListaVizinhos() {
        return listaVizinhos;
    }
}