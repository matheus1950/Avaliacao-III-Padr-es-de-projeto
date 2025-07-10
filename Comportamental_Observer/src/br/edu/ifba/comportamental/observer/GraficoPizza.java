package br.edu.ifba.comportamental.observer;

public class GraficoPizza implements Observer {
    private String nome;

    public GraficoPizza(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String nomeCelula, int novoValor) {
        System.out.println("[" + this.nome + "] Notificado! Atualizando gráfico de pizza.");
        System.out.println("=> Nova fatia para '" + nomeCelula + "' agora representa " + novoValor + "% do total.");
    }
}