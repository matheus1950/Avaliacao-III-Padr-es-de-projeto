package br.ifba.edu.builder;

import java.time.LocalDateTime;

public class PartidaBuilder{
	
	
	private String descricao;
	private LocalDateTime inicio;
	private LocalDateTime termino; 
	private Integer prioridade;
	private String equipeA;
	private String equipeB;
	private Integer placarA;
	private Integer placarB;

	public PartidaBuilder reset() {
		this.descricao = "";
		this.inicio = LocalDateTime.now();
		this.termino =  null; 
		this.prioridade = 5;
		this.equipeA = null;
		this.equipeB = null;
		this.placarA = 0;
		this.placarB = 0;
		return this;

	}

	public PartidaBuilder setDescricao(String string) {
		this.descricao = string;
		return this;
		
	}

	public PartidaBuilder setInicio(LocalDateTime time) {
		this.inicio = time;
		return this;
	}

	public PartidaBuilder setFim(LocalDateTime time) {
		this.termino = time;
		return this;
	}

	public PartidaBuilder withPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
		return this;
	}

	public PartidaBuilder withMandante(String equipeA) {
		this.equipeA = equipeA;
		return this;
	}

	public PartidaBuilder withVisitante(String equipeB) {
		this.equipeB = equipeB;
		return this;
		
	}

	public PartidaBuilder setPlacar(Integer placarA, Integer placarB) {
		this.placarA = placarA;
		this.placarB = placarB;
		return this;
	}
	
	public Partida getPartida(String descricao) {
		if(this.termino == null)
			this.termino = this.inicio.plusHours(2);
		return new Partida(descricao, this.inicio, this.termino, this.prioridade, this.equipeA,
				this.equipeB, this.placarA, this.placarB);
	}

}
