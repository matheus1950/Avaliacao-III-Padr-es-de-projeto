package br.ifba.edu.builder;

import java.time.LocalDateTime;

public class PartidaBuilder implements CopaBuilder{
	
	
	private String descricao;
	private LocalDateTime inicio;
	private LocalDateTime termino; 
	private Integer prioridade;
	private String equipeA;
	private String equipeB;
	private Integer placarA;
	private Integer placarB;

	@Override
	public void reset() {
		this.descricao = "";
		this.inicio = LocalDateTime.now();
		this.termino =  null; 
		this.prioridade = 5;
		this.equipeA = null;
		this.equipeB = null;
		this.placarA = 0;
		this.placarB = 0;

	}

	@Override
	public void setDescricao(String string) {
		this.descricao = string;
		
	}

	@Override
	public void setInicio(LocalDateTime time) {
		this.inicio = time;
	}

	@Override
	public void setFim(LocalDateTime time) {
		this.termino = time;
	}

	@Override
	public void withPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public void withMandante(String equipeA) {
		this.equipeA = equipeA;
	}

	@Override
	public void withVisitante(String equipeB) {
		this.equipeB = equipeB;
		
	}

	@Override
	public void setPlacar(Integer placarA, Integer placarB) {
		this.placarA = placarA;
		this.placarB = placarB;		
	}
	
	public Partida getPartida() {
		if(this.termino == null)
			this.termino = this.inicio.plusHours(2);
		return new Partida(this.descricao, this.inicio, this.termino, this.prioridade, this.equipeA,
				this.equipeB, this.placarA, this.placarB);
	}

}
