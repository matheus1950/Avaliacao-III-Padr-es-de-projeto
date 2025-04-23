package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioTerceirizado implements Promovivel{

	private String cnpj;
	private DadosCadastrais data;
	
	public FuncionarioTerceirizado(String matricula, String nome, BigDecimal salario, Cargo cargo,
			LocalDate dtAdmissao, String cnpj) {
		super();
		this.data  = new DadosCadastrais(matricula, nome,
										 salario, cargo, dtAdmissao);
		this.cnpj = cnpj;
	}
	
	public Cargo getCargo() {
		return this.data.getCargo();
	}

	public void setCargo(Cargo novoCargo) {
		this.data.setCargo(novoCargo);
	}	
	
	public String toString() {
		String rep = this.data.toString() + "\n";
		rep = rep + "CNPJ: " + this.cnpj + "\n";
		return rep;
			   
 	}	

	
	
	

}
