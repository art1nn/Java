package com.gerencia;

public class Main {
    public static void main(String[] args) {
        Capital vitoria = new Capital("vitoria");
        Capital salvador = new Capital("salvador");
        Capital sao_paulo = new Capital("sao paulo");
        Capital belo_horizonte = new Capital("belo horizonte");
        Capital rio_de_janeiro = new Capital("rio de janeiro");
        Capital fortaleza = new Capital("fortaleza");
        Capital aracaju = new Capital("aracaju");
        Capital recife = new Capital("recife");
        Capital belem = new Capital("belem");
        Capital sao_luis = new Capital("sao luis");
        Capital teresina = new Capital("teresina");
        Capital natal = new Capital("natal");
        Capital brasilia = new Capital("brasilia");
        Capital cuiaba = new Capital("cuiaba");
        Capital goiania = new Capital("goiania");
        Capital palmas = new Capital("palmas");
        Capital porto_velho = new Capital("porto velho");
        Capital manaus = new Capital("manaus");
        Capital rio_branco = new Capital("rio branco");
        Capital maceio = new Capital("maceio");
        Capital joao_pessoa = new Capital("joao pessoa");
        Capital curitiba = new Capital("curitiba");
        Capital florianopolis = new Capital("florianopolis");
        Capital porto_alegre = new Capital("porto alegre");
        Capital campo_grande = new Capital("campo grande");
        Capital boa_vista = new Capital("boa vista");
        Capital macapa = new Capital("macapa");

        // Definição dos vizinhos
        vitoria.getVizinhos().settar_vizinho(vitoria, rio_de_janeiro, 2.0);
        vitoria.getVizinhos().settar_vizinho(vitoria, belo_horizonte, 3.0);
        vitoria.getVizinhos().settar_vizinho(vitoria, salvador, 4.0);
        vitoria.getVizinhos().settar_vizinho(vitoria, curitiba, 10.0);

        salvador.getVizinhos().settar_vizinho(salvador, aracaju, 3.0);
        salvador.getVizinhos().settar_vizinho(salvador, belo_horizonte, 5.0);
        salvador.getVizinhos().settar_vizinho(salvador, teresina, 6.0);

        brasilia.getVizinhos().settar_vizinho(brasilia, goiania, 1.0);
        brasilia.getVizinhos().settar_vizinho(brasilia, cuiaba, 3.0);
        brasilia.getVizinhos().settar_vizinho(brasilia, belo_horizonte, 4.0);
        brasilia.getVizinhos().settar_vizinho(brasilia, salvador, 5.0);

        sao_luis.getVizinhos().settar_vizinho(sao_luis, belem, 3.0);
        sao_luis.getVizinhos().settar_vizinho(sao_luis, teresina, 2.0);

        fortaleza.getVizinhos().settar_vizinho(fortaleza, natal, 2.5);
        fortaleza.getVizinhos().settar_vizinho(fortaleza, sao_luis, 3.0);
        fortaleza.getVizinhos().settar_vizinho(fortaleza, teresina, 2.0);

        teresina.getVizinhos().settar_vizinho(teresina, belem, 4.0);
        teresina.getVizinhos().settar_vizinho(teresina, recife, 5.0);

        recife.getVizinhos().settar_vizinho(recife, joao_pessoa, 1.5);
        recife.getVizinhos().settar_vizinho(recife, maceio, 2.0);

        maceio.getVizinhos().settar_vizinho(maceio, aracaju, 2.0);

        campo_grande.getVizinhos().settar_vizinho(campo_grande, cuiaba, 3.0);
        campo_grande.getVizinhos().settar_vizinho(campo_grande, goiania, 4.0);

        curitiba.getVizinhos().settar_vizinho(curitiba, florianopolis, 2.0);
        curitiba.getVizinhos().settar_vizinho(curitiba, sao_paulo, 3.0);

        florianopolis.getVizinhos().settar_vizinho(florianopolis, porto_alegre, 3.0);

        porto_velho.getVizinhos().settar_vizinho(porto_velho, rio_branco, 2.5);
        porto_velho.getVizinhos().settar_vizinho(porto_velho, manaus, 3.5);

        manaus.getVizinhos().settar_vizinho(manaus, boa_vista, 4.0);

        boa_vista.getVizinhos().settar_vizinho(boa_vista, macapa, 5.0);
        /* LinkedList<Vizinho> lista_vizinhos_es = vitoria.getVizinhos().getListaVizinhos();

        for(Vizinho vizinho : lista_vizinhos_es){
            System.out.println(vizinho.getCapital().getNome());
        } */

        sao_paulo.dijkstra(belem);
    }
}