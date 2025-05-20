package br.ifba.edu.builder;

import java.time.LocalDateTime;

public record Partida (String descricao, LocalDateTime inicio, LocalDateTime termino, Integer prioridade, String equipeA,
		String equipeB, Integer placarA, Integer placarB) {
	
	

}
