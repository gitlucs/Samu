package samu;

import java.util.ArrayList;

public class Sistema {
    private int contadorAjudas;
    private int contadorTemas;
    private ArrayList<Ajuda> ajudas;
    private ArrayList<Tema> temas;

    public Sistema() {
        ajudas = new ArrayList<>();
        temas = new ArrayList<>();
    }

    public int criarAjuda(String descricao, String nome){
        if (contadorAjudas >= 1000){
            return -1;
        }
        Ajuda a = new Ajuda(descricao, nome, contadorAjudas);
        ajudas.add(a);
        return contadorAjudas++;
    }

    public void apoiarAjuda(int idAjuda){
        ajudas.get(idAjuda).incrementaApoio();
    }

    public String exibirAjuda(int idAjuda){
        return ajudas.get(idAjuda).toString();
    }

    public void criarMensagemApoio(int idAjuda, String descricao, String autor){
        ajudas.get(idAjuda).adicionaMensagem(descricao, autor);
    }

    public String listarMensagens(int idAjuda){
        return ajudas.get(idAjuda).exibirMensagens();
    }

    public void criarTema(String nome, int id){
        if (contadorTemas >= 100){
            return;
        }
        Tema t = new Tema(nome, id);
        temas.add(t);//atencao para gerencia de arraycheio
        contadorTemas++;
    }

    public void adicionarAjudaTema(int idAjuda, int idTema){
        Tema t = localizarTema(idTema);
        if(t == null)//tema nao existe
            return;

        Ajuda a = ajudas.get(idAjuda);
        t.adicionaAjuda(a);//note que a ajuda adicionada ja existe no sistema

    }
    public int contarAjudasTema(int idTema) {
        Tema t = localizarTema(idTema);
        if(t == null)//tema nao existe;
            return 0;

        return t.contarAjudas();
    }

    public String exibirTema(int idTema) {
        Tema t = localizarTema(idTema);
        if(t == null){//tema nao existe;
            return "";
        }
        return t.toString();
    }

    private Tema localizarTema(int idTema) {
        //poderia tambem retorna o indice do tema no array
        for(Tema t:temas) {
            if(t.getId() == idTema) {
                return t;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Sistema s = new Sistema();
        System.out.println(s.criarAjuda("cafecafecafe", "prof anonimo"));
        System.out.println(s.criarAjuda("trocar a cor do eclipse", "matheus g"));
        System.out.println(s.exibirAjuda(0));
        s.apoiarAjuda(0);
        System.out.println(s.exibirAjuda(0));
        System.out.println(s.listarMensagens(0));
        s.criarMensagemApoio(0, "vamos la!", "livia");
        System.out.println(s.listarMensagens(0));
        s.criarTema("p2", 42);
        s.adicionarAjudaTema(0,42);
    }

}