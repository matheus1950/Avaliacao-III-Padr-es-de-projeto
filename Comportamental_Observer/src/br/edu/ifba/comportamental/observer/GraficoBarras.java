package br.edu.ifba.comportamental.observer;

public class GraficoBarras implements Observer {
    private String nome;

    public GraficoBarras(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String nomeCelula, int novoValor) {
        System.out.println("[" + this.nome + "] Notificado! Atualizando gráfico de barras.");
        System.out.println("=> Nova visualização para '" + nomeCelula + "': " + desenharBarras(novoValor));
    }

    private String desenharBarras(int valor) {
        StringBuilder barras = new StringBuilder();
        for (int i = 0; i < valor; i++) {
            barras.append("❚");
        }
        return barras.toString();
    }
}
