package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;

public class CalculadoraSalarialFilial {
	
	public void aumentarSalario(Funcionario funcionario, 
								BigDecimal pctAumento) throws DomainException {
		if(pctAumento.floatValue() < 0.05)
			throw new DomainException("Percentual de Aumento Invalido");
		BigDecimal salarioAtual = funcionario.getSalario();	
		BigDecimal aumento = salarioAtual.multiply(pctAumento);
		BigDecimal novoSalario = salarioAtual.add(aumento);
		funcionario.aumentarSalario(novoSalario);
	}
	

}
