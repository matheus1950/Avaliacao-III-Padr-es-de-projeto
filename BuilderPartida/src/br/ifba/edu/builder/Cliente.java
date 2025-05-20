package br.ifba.edu.builder;

public class Cliente {
	
	public void run() {
		
		QuantidadeGolsBuilder copaGolsBuilder = new QuantidadeGolsBuilder();
		PartidaBuilder copaPartidaBuilder = new PartidaBuilder();
		 
		DirectorBrasilCampeao director = new DirectorBrasilCampeao();
		director.setBuilder(copaPartidaBuilder);
		
		director.final1970("Final da World Cup de 1970");
		Partida partida = copaPartidaBuilder.getPartida();
		
		director.setBuilder(copaGolsBuilder);
		director.final1994("Final da World Cup de 1970");
		QuantidadeGols qdeGols = copaGolsBuilder.get(); 
		
		
		System.out.println(partida);
		System.out.println(qdeGols);
		
		
	}
	
	
	public static void main(String[] args) {
		new Cliente().run();
	}

}
