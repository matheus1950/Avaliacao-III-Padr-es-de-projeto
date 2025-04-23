package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;

public interface Regra {
	public void ok(Aumentavel funcionario, BigDecimal percentual) 
			throws DomainException;
}
