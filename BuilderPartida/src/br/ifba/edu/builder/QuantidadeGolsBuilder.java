package br.ifba.edu.builder;

import java.time.LocalDateTime;

public class QuantidadeGolsBuilder implements CopaBuilder{
	
	private Integer qtdeGols;

	@Override
	public void reset() {
		
		
	}

	@Override
	public void setDescricao(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInicio(LocalDateTime time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFim(LocalDateTime time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withPrioridade(Integer prioridade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withMandante(String equipeA) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withVisitante(String equipeB) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlacar(Integer placarA, Integer placarB) {
		this.qtdeGols = placarA + placarB; 
	}
	
	public QuantidadeGols get() {
		return new QuantidadeGols(this.qtdeGols); 
	}
	

}
