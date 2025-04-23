package br.ifba.edu;

public class App {

	public void run() throws Exception {
		PessoaFisica pf = new PessoaFisica(new CPF("07194726017"));
		if(pf.isCPFValido()) {
			System.out.println(pf.getCPFFormatado());
			return;
		}
		System.out.println("CPFINVALIDO");
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		new App().run();
	}
}
