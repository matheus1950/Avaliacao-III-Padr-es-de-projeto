package br.ifba.edu.aval;

import java.time.Duration;

import br.ifba.edu.aval.chain.RegraChegada;
import br.ifba.edu.aval.chain.RegraOrdemPrismas;
import br.ifba.edu.aval.chain.RegraPenalizaAtraso;
import br.ifba.edu.aval.chain.RegraTempoMaximo;
import br.ifba.edu.aval.chain.RegraTodosPrismas;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.Apurador;
import br.ifba.edu.aval.model.BoletimProva;

public class AppAvaliacao3 extends AppAvaliacaoBase{
	
	private Apurador apurador;
	
	public AppAvaliacao3() {
		//this.apurador = new Apurador(Duration.ofMinutes(120));
		RegraChegada r1 = new RegraChegada();
		RegraTempoMaximo r2 = new RegraTempoMaximo(Duration.ofMinutes(120));
		RegraOrdemPrismas r3 = new RegraOrdemPrismas();
		RegraTodosPrismas r4 = new RegraTodosPrismas();
		RegraPenalizaAtraso r5 = new RegraPenalizaAtraso();

		r1.setProxima(r2);
		r2.setProxima(r3);
		r3.setProxima(r4);
		r4.setProxima(r5);

		this.apurador = new Apurador(r1);
	}
	
	public void aval() {
		System.out.println("* AVALIAÇÃO III **************************");
		this.questao1();
		System.out.println("******************************************");
		this.questao2();
	}

	public void questao1() {
		System.out.println("QUESTÃO 1");
		this.makeBoletinsProva();
		try {
			this.runAtleta4Aval3();
			this.apurarBoletimProva(this.atleta4);
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta4.cboNumero() + e.getMessage());
		}		
	}
	
	public void questao2() {
		System.out.println("QUESTÃO 2");
		this.makeBoletinsProva();
		System.out.println("**Corrida do Atleta1**");
		try {
			this.runAtleta1Aval1();
			this.apurarBoletimProva(this.atleta1);
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta1.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("**Corrida do Atleta2**");
		try {
			this.runAtleta2Aval1();
			this.apurarBoletimProva(this.atleta2);
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta2.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("**Corrida do Atleta3**");
		try {
			this.runAtleta3Aval3();
			this.apurarBoletimProva(this.atleta3);
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta3.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("******************************************");
		System.out.println("**Corrida do Atleta4**");
		try {
			this.runAtleta4Aval3();
			this.apurarBoletimProva(this.atleta4);
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta4.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("******************************************");

		System.out.println("**Corrida do Atleta5**");
		try {
			this.runAtleta5Aval3();
			this.apurarBoletimProva(this.atleta5);
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta5.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("******************************************");

		System.out.println("**Corrida do Atleta6**");
		try {
			this.runAtleta6Aval3();
			this.apurarBoletimProva(this.atleta6);
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta6.cboNumero() + ": " + e.getMessage());
		}
		
	}
	
	public void apurarBoletimProva(BoletimProva boletimProva) {
		System.out.println("*Apurando Atleta (" + boletimProva.cboNumero() + ") ********");
		try {
			System.out.println(apurador.apurar(boletimProva));
		} catch (DNFException e) {
			System.err.println(boletimProva.cboNumero() + " não concluiu - " + e.getMessage());
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + boletimProva.cboNumero() + ". Não é permitido apurar: " + e.getMessage());
		}			
	}

	
	public static void main(String[] args)  {
		new AppAvaliacao3().aval();
	}

}
