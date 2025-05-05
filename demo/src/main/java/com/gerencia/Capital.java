package com.gerencia;
import java.util.Stack;

import com.gerencia.utils.BinaryHeap;

public class Capital implements Comparable<Capital>{
    private String nome;
    private Vizinhos vizinhos; // lista de VIZINHO, e VIZINHO é uma lista = [objeto, distancia]
    private Double menor_distancia_atual;
    private Capital anterior;
    private boolean ativo;
    
    public Capital(String nome) {
        this.nome = nome;
        this.menor_distancia_atual = Double.MAX_VALUE; 
        this.anterior = null;
        this.ativo = true;
        this.vizinhos = new Vizinhos(); 
    }
    
    public void Comparacao(Vizinho vizinho ){
        if(this.menor_distancia_atual + vizinho.getDistancia() < vizinho.getCapital().getMenor_distancia_atual()){
            vizinho.getCapital().setAnterior(this);
            vizinho.getCapital().setMenor_distancia_atual(this.menor_distancia_atual + vizinho.getDistancia());
        }
    }

    // public static Capital retornar_menor(LinkedList<Capital> lista_capitais2 ){
    //     Capital capital = new Capital("teste");
    //     for(Capital capital_comparacao : lista_capitais2){
    //         if(capital_comparacao.getMenor_distancia_atual() < capital.getMenor_distancia_atual()){
    //             capital = capital_comparacao;
    //         }
    //     }
    //     return capital;
    // }

    public void dijkstra(Capital destino){

        //LinkedList<Capital> lista_prioridade = new LinkedList<>();
        BinaryHeap<Capital> lista_prioridade = new BinaryHeap<Capital>();

        lista_prioridade.insert_node(this);
        this.setMenor_distancia_atual(0.0);  
            
        while (!lista_prioridade.isEmpty()) {
            Capital capital = lista_prioridade.pop();

            capital.setAtivo(false);
            if(capital == destino){
                break;
            }
            for(Vizinho vizinho : capital.getVizinhos().getListaVizinhos()){
                if(vizinho.getCapital().getAtivo() == true){
                    capital.Comparacao(vizinho);
                    if(!lista_prioridade.contains(vizinho.getCapital())){
                        lista_prioridade.insert_node(vizinho.getCapital());
                    }
                    
                }
            }
        }

        Capital capital_path = destino;
        double distancia_final = destino.menor_distancia_atual;
        Stack<String> pilha = new Stack<>(); 

        try{
            while (capital_path != null) {
                //System.out.println(capital_path.getNome());

                pilha.add(capital_path.getNome());

                capital_path = capital_path.getAnterior();
            }
            
            StringBuilder caminho = new StringBuilder();
            while (!pilha.isEmpty()) {
                caminho.append(pilha.pop());
                if (!pilha.isEmpty()) {
                    caminho.append(" -> ");
                }
            }
            System.out.println("**************************************************************************************************************");
            System.out.println("Rota: " + caminho.toString());
            System.out.println("Distancia total: " + distancia_final + " KM");
            System.out.println("**************************************************************************************************************");

        }catch(NullPointerException e ){
            System.out.println("ACABOU");
        }

    }

//======================================================================================================
//======================================================================================================
//======================================================================================================

//     GetSet
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMenor_distancia_atual() {
        return menor_distancia_atual;
    }

    public void setMenor_distancia_atual(Double menor_distancia_atual) {
        this.menor_distancia_atual = menor_distancia_atual;
    }

    public Capital getAnterior() {
        return anterior;
    }

    public void setAnterior(Capital anterior) {
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

    @Override
    public int compareTo(Capital o) {
        return Double.compare(this.menor_distancia_atual, o.menor_distancia_atual);
    }
    @Override
    public String toString() {
        return String.valueOf(menor_distancia_atual);
    }
}
