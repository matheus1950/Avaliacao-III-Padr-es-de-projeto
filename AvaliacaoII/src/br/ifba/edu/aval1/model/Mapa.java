package br.ifba.edu.aval1.model;

import java.util.Arrays;
import java.util.List;

public record Mapa(Sexo sexo, Idade idade, Dificuldade dificuldade,
				   Integer escala, Integer ecn, PontoGeografico largada,
				   PontoGeografico partida, List<Prisma> prismas, PontoGeografico chegada) {
	
	
	public String categoria() {
		return this.sexo() + " " + this.idade() + " " + this.dificuldade();
	}
	

}
