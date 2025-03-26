package com.gerencia;

public class Main {
    public static void main(String[] args) {
        Capital ES = new Capital("vitoria");

        ES.getVizinhos().settar_vizinho("riodejaneiro", 1.0f);
        ES.getVizinhos().settar_vizinho("belohorizonte", 2.0f);

    }
}