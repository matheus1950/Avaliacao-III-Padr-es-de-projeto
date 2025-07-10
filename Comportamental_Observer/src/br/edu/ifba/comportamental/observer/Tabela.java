package br.edu.ifba.comportamental.observer;

public class Tabela implements Observer {
    private String nome;

    public Tabela(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String nomeCelula, int novoValor) {
        System.out.println("[" + this.nome + "] Notificado! Atualizando a exibição da tabela.");
        System.out.println("=> Célula '" + nomeCelula + "' atualizada com o valor: " + novoValor);
    }
}