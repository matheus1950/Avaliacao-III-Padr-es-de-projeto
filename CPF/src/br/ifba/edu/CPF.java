package br.ifba.edu;

public class CPF {
	
	private String cpf;
	
	public CPF(String cpf) throws Exception{
		
		if(!this.validarCPF(cpf))
			throw new Exception("Valor Errado");
		this.setCpf(cpf);
	}	
	
	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
	public Boolean isCPFValido() {
		return this.validarCPF(this.getCpf());
	}
	
	public String getCPFFormatado() {
		return this.formatarCPF(this.getCpf());
	}
	
	private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int digito1 = calcularDigitoVerificador(digitos, 9);
        int digito2 = calcularDigitoVerificador(digitos, 10);
        return digitos[9] == digito1 && digitos[10] == digito2;
    }

    private int calcularDigitoVerificador(int[] digitos, int posicao) {
        int soma = 0;
        for (int i = 0; i < posicao; i++) {
            soma += digitos[i] * (posicao + 1 - i);
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }
    
    private  String formatarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        if (cpf == null || cpf.length() != 11) {
            return cpf; // Retorna o CPF original se não tiver 11 dígitos
        }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }	
	

}
