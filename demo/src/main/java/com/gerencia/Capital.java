package com.gerencia;

public class Capital {
    private String nome;
    private float menor_distancia_atual;
    private String anterior;
    private boolean ativo;
    private Vizinhos vizinhos; 

    public Capital(String nome) {
        this.nome = nome;
        this.menor_distancia_atual = Float.MAX_VALUE; 
        this.anterior = null;
        this.ativo = true;
        this.vizinhos = new Vizinhos(); 
    }

    // GetSet
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMenor_distancia_atual() {
        return menor_distancia_atual;
    }

    public void setMenor_distancia_atual(float menor_distancia_atual) {
        this.menor_distancia_atual = menor_distancia_atual;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Vizinhos getVizinhos() {
        return vizinhos;
    }
}
