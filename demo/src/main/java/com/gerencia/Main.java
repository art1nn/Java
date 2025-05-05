package com.gerencia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Capital> tabela_hash_capitais = new HashMap<>();
        String origem_string;
        String destino_string;
        Capital origem;
        Capital destino;
        Scanner scan = new Scanner(System.in);

        List<String> nomesCapitais = Arrays.asList(
            "vitoria", "salvador", "sao paulo", "belo horizonte", "rio de janeiro", "fortaleza",
            "aracaju", "recife", "belem", "sao luis", "teresina", "natal", "brasilia", "cuiaba",
            "goiania", "palmas", "porto velho", "manaus", "rio branco", "maceio", "joao pessoa",
            "curitiba", "florianopolis", "porto alegre", "campo grande", "boa vista", "macapa"
        );

        for (String nome : nomesCapitais) {
            adicionarCapital(tabela_hash_capitais, nome);
        }

        Object[][] ligacoes = {
            {"vitoria", "rio de janeiro", 413.0},
            {"vitoria", "belo horizonte", 378.0},
            {"rio de janeiro", "belo horizonte", 340.0},
            {"sao paulo", "rio de janeiro", 357.0},
            {"sao paulo", "belo horizonte", 490.0},
            {"sao paulo", "goiania", 811.0},
            {"cuiaba","goiania",745.0},
            {"porto velho", "cuiaba", 1144.0},  
            {"goiania","salvador",1241.0},
            {"sao paulo","campo grande", 894.0},
            {"vitoria", "salvador", 839.0},
            {"campo grande", "curitiba", 777.0},
            {"salvador", "aracaju", 277.0},
            {"salvador", "belo horizonte", 965.0},
            {"salvador", "teresina", 994.0},
            {"brasilia", "goiania", 173.0},
            {"brasilia", "cuiaba", 877.0},
            {"brasilia", "belo horizonte", 620.0},
            {"belo horizonte", "goiania", 666.0},
            {"brasilia", "salvador", 1058.0},
            {"sao luis", "belem", 482.0},
            {"belem", "macapa", 330.0},
            {"belem", "manaus", 1293.0},
            {"sao luis", "teresina", 329.0},
            {"fortaleza", "natal", 435.0},
            {"natal", "joao pessoa", 152.0},
            {"palmas", "sao luis", 959.0},
            {"fortaleza", "teresina", 497.0},
            {"fortaleza","recife", 630.0},
            {"teresina", "belem", 750.0},
            {"palmas","belem", 973.0},
            {"teresina", "recife", 935.0},
            {"recife", "joao pessoa", 104.0},
            {"recife", "maceio", 202.0},
            {"maceio", "aracaju", 201.0},
            {"campo grande", "cuiaba", 560.0},
            {"campo grande", "goiania", 705.0},
            {"curitiba", "florianopolis", 251.0},
            {"curitiba", "sao paulo", 339.0},
            {"florianopolis", "porto alegre", 376.0}, 
            {"porto velho", "rio branco", 484.0},
            {"porto velho", "manaus", 760.0},
            {"manaus", "boa vista", 750.0},
            {"manaus", "rio branco", 1149.0},
            {"palmas", "goiania", 725.0},
            {"palmas", "belo horizonte", 1182.0},
            {"palmas", "salvador", 1115.0},
            {"palmas", "teresina", 831.0},
            {"palmas", "brasilia", 700.0},
            {"palmas", "cuiaba", 1035.0}
        };

        for (Object[] ligacao : ligacoes) {
            ligarCapitais(tabela_hash_capitais, (String) ligacao[0], (String) ligacao[1], (double) ligacao[2]);
        }

        System.out.print("Origem: ");
        origem_string = scan.nextLine();

        System.out.print("Destino: ");
        destino_string = scan.nextLine();

        origem = tabela_hash_capitais.get(origem_string.toLowerCase());
        destino = tabela_hash_capitais.get(destino_string.toLowerCase());

        if((origem != null)&&(destino != null)){
            origem.dijkstra(destino);
        }else{
            System.out.println("Digite o nome das capitais corretamente!");
        }
        scan.close();
    }

    private static void adicionarCapital(HashMap<String, Capital> mapa, String nome) {
        mapa.put(nome, new Capital(nome));
    }

    private static void ligarCapitais(HashMap<String, Capital> mapa, String origem, String destino, double distancia) {
        Capital capOrigem = mapa.get(origem);
        Capital capDestino = mapa.get(destino);
        capOrigem.getVizinhos().settar_vizinho(capOrigem, capDestino, distancia);
    }
}
