package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public class BoletimProva {

	public static final Integer PRE_PROVA = 0;
	public static final Integer MOMENTO_LARGADA = 1;
	public static final Integer PISTA = 2;
	public static final Integer POS_PROVA = 3;
	
	public String cboNumero;
	public ListaPassagens passagens;
	public Long minutoPartidaPrevisto;
	public Long minutoPartidaEfetivo;
	
	private Integer fase;
	
	
	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.fase = BoletimProva.PRE_PROVA;
	}
	

	public List<Integer> getOrdemPrismas() {
		return this.passagens.getOrdemPassagem();
	}
	
	public String cboNumero() {
		return this.cboNumero;
	}
	
	@Override
	public String toString() {
		return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + "]";
	}	
	
	public Duration getTempo(Integer prismaID) {
		return this.passagens.getTempo(prismaID);
	}
	
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		if(this.fase != BoletimProva.PISTA)
			throw new AtividadeNaoPermitidaException("Não pode registrar prisma");
		this.passagens.registrarPassagem(prismaID, tempo);
		
	}

	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		if(this.fase == BoletimProva.PRE_PROVA)
			throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
		this.minutoPartidaEfetivo = minutoPartidaEfetivo;
	}
	
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		if(this.fase > BoletimProva.PRE_PROVA)
			return minutoPartidaEfetivo - minutoPartidaPrevisto;
		throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
	}	
	
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		if(this.fase == BoletimProva.PRE_PROVA)
			this.fase++;
		else if(this.fase != BoletimProva.MOMENTO_LARGADA)
			throw new AtividadeNaoPermitidaException("Fase não permite se apresentar pra largada.");
	}
	
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		if(this.fase == BoletimProva.MOMENTO_LARGADA)
			this.fase++;
		else if(this.fase != BoletimProva.PISTA)
			throw new AtividadeNaoPermitidaException("Fase não permite largar.");
	}

	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		if(this.fase == BoletimProva.PISTA) {
			this.fase++;
			this.passagens.registrarPassagem(Prisma.CHEGADA, tempo);
		}	
		else if(this.fase != BoletimProva.PISTA)
			throw new AtividadeNaoPermitidaException("Fase não permite registro de chegada.");
	}	
	
	

}
