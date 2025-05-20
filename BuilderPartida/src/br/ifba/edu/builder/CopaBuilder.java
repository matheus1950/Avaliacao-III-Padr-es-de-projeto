package br.ifba.edu.builder;

import java.time.LocalDateTime;

public interface CopaBuilder {

	public void reset();
	public void setDescricao(String string);
	public void setInicio(LocalDateTime time);
	public void setFim(LocalDateTime time);
	public void withPrioridade(Integer prioridade);
	public void withMandante(String equipeA);
	public void withVisitante(String equipeB);
	public void setPlacar(Integer placarA, Integer placarB);

}
