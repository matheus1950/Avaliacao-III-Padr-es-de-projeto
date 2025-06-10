package br.edu.ifba.flyweight;

public class CaractereConcreteFlyweight implements CaractereFlyweight {
    private char valor;
    private String fonte;
    private int tamanho;

    public CaractereConcreteFlyweight(char valor, String fonte, int tamanho) {
        this.valor = valor;
        this.fonte = fonte;
        this.tamanho = tamanho;
    }

    @Override
    public void exibir(int posicao) {
        System.out.println("Caractere: " + valor + ", Fonte: " + fonte + ", Tamanho: " + tamanho + ", Posição: (" + posicao + ")");
    }
}