package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DadosCadastrais {
	public String matricula;
	public String nome;
	public BigDecimal salario;
	public Cargo cargo;
	public LocalDate dtUltimoReajuste;
	public LocalDate dtAdmissao;

	public DadosCadastrais(String matricula, String nome, BigDecimal salario, Cargo cargo,
			   LocalDate dtAdmissao) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
		this.dtAdmissao = dtAdmissao;
		this.dtUltimoReajuste = dtAdmissao;		
	}
	
	private String getMatricula() {
		return this.matricula;
	}
	
	private String getNome() {
		return this.nome;
	}
	
	public BigDecimal getSalario() {
		return this.salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}	
	
	private LocalDate getDtUltimoReajuste() {
		return this.dtUltimoReajuste;
	}
	
	public void setDtUltimoReajuste(LocalDate dtUltimoReajuste) {
		this.dtUltimoReajuste = dtUltimoReajuste;
	}
	

	public LocalDate getDtAdmissao() {
		return this.dtAdmissao;
	}

	public Cargo getCargo() {
		return this.cargo;
	}	
	
	public String toString() {
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String rep = "MATRICULA: " + this.getMatricula() + "\n" + 
					 "NOME: " + this.getNome() + "\n" +
					 "CARGO: " + this.getCargo() + "\n" +
					 "DATA ADMISSÃO: " + this.getDtAdmissao().format(format) + "\n" +
					 "SALÁRIO: " +  NumberFormat.getCurrencyInstance(java.util.Locale.of("PT", "BR")).format(this.getSalario()) + "\n" +
					 "DATA ÚLTIMO REAJUSTE: " + this.getDtUltimoReajuste().format(format) + "\n";
		return rep;
			   
 	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}	
	
}