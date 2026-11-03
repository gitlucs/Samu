package samu;

import java.util.ArrayList;

public class Tema {
    private String nome;
    private int id;
    private ArrayList<Ajuda> ajudas;
    private int contadorAjudas;

    public Tema(String nome, int id) {
        this.nome = nome;
        this.id = id;
        ajudas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void adicionaAjuda(Ajuda ajuda){
        ajudas.add(ajuda);//atencao para gerencia de arrays
        contadorAjudas++;
    }

    public int contarAjudas(){
        return contadorAjudas;
    }

    public String toString(){
        return nome + "\n"+
                ajudas.toString();
    }

}