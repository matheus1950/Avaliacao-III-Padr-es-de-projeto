package br.ifba.edu.aval1.model;

import java.time.Duration;

import br.ifba.edu.aval1.prototype.ListaPassagens;

public class BoletimProva {
	
	public String cboNumero;
	public ListaPassagens passagens;
	
	
	public BoletimProva(String cboNumero, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
	}
	
	
	public void registrar(Integer prismaID, Duration tempo) {
		this.passagens.registrarPassagem(prismaID, tempo);
	}


	@Override
	public String toString() {
		return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + "]";
	}
	
	
	
	

}
