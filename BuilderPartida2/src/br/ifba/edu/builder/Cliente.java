package br.ifba.edu.builder;

import java.time.LocalDateTime;

public class Cliente {
	
	public void run() {
		
		Partida partida = Partida.builder().reset()
								   .setDescricao("Final da World Cup de 1970")
								   .setInicio(LocalDateTime.of(1970, 06, 01, 12, 0))
								   .withMandante("Brasil")
								   .withVisitante("Italia")
								   .setPlacar(4, 1).getPartida("Foi 4a1");
		System.out.println(partida);
	}
	
	
	public static void main(String[] args) {
		new Cliente().run();
	}

}
