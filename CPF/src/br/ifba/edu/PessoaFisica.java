package br.ifba.edu;

public class PessoaFisica {
	private CPF cpf;
	
	public PessoaFisica(CPF cpf) {
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
