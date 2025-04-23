package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;

public class CalculadoraSalarialComTetoSalarial extends CalculadoraSalarialFilial{
	
	public void aumentarSalario(Funcionario funcionario, 
								BigDecimal pctAumento) throws DomainException {
		Cargo cargo = funcionario.getCargo();
		BigDecimal tetoSalarial = cargo.getTetoSalarial();
		BigDecimal salarioAtual = funcionario.getSalario();	
		BigDecimal aumento = salarioAtual.multiply(pctAumento);
		BigDecimal novoSalario = salarioAtual.add(aumento);
		if(novoSalario.compareTo(tetoSalarial) > 0)
			throw new DomainException("Estoura o teto");
		funcionario.aumentarSalario(novoSalario);
	}
	

}
