package br.edu.ifba.flyweight;

public class CaractereClient {

	private CaractereFlyweight flyweight;
	private int posicao; 
	
	public CaractereClient(char valor, String fonte, int tamanho, int posicao) {
		this.flyweight = CaractereFlyweightFactory.getCaractere(valor, fonte, tamanho);
		this.posicao = posicao;
	}
	
	public void exibir() {
		this.flyweight.exibir(this.posicao);
	}
	
	
}
