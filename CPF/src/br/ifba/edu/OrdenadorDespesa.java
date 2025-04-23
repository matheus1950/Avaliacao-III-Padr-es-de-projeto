package br.ifba.edu;

public class OrdenadorDespesa {
	
	private CPF cpf;
	
	public OrdenadorDespesa(CPF cpf) {
		super();
		this.setCpf(cpf);
	}

	private void setCpf(CPF cpf) {
		this.cpf = cpf;
	}	
	
	public Boolean isCPFValido() {
		return this.cpf.isCPFValido();
	}
	
	public String getCPFFormatado() {
		return this.cpf.getCPFFormatado();
	}
	

}
