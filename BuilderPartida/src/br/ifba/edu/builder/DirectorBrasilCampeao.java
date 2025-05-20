package br.ifba.edu.builder;

import java.time.LocalDateTime;

public class DirectorBrasilCampeao {
	
	private CopaBuilder builder;
	
	
	public void setBuilder(CopaBuilder builder) {
		this.builder = builder;
	}
	
	
	public void final1970(String descricao) {
		this.builder.reset();
		this.builder.setDescricao(descricao);
		this.builder.setInicio(LocalDateTime.of(1970, 06, 01, 12, 0));
		this.builder.withMandante("Brasil");
		this.builder.withVisitante("Italia");
		this.builder.setPlacar(4, 1);
	}
	
	
	public void final1994(String descricao) {
		this.builder.reset();
		this.builder.setDescricao(descricao);
		this.builder.setInicio(LocalDateTime.of(1970, 06, 01, 12, 0));
		this.builder.withMandante("Brasil");
		this.builder.withVisitante("Italia");
		this.builder.setPlacar(0, 0);
	}	
	
	

	

}
