package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.AtividadeNaoPrecisaDeAlteracaoException;
import br.ifba.edu.aval.state.StateProva;
import br.ifba.edu.aval.state.StatePreProva;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public class BoletimProva {
	
	public String cboNumero;
	public ListaPassagens passagens;
	public Long minutoPartidaPrevisto;
	public Long minutoPartidaEfetivo;
	
	private StateProva faseAtual;
	
	
	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.faseAtual = new StatePreProva();
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
	    this.faseAtual.registrar(prismaID, tempo, this);
	}

	public void registrarAtrasoPartida(Long minutoEfetivo) throws AtividadeNaoPermitidaException {
	    this.faseAtual.registrarAtrasoPartida(minutoEfetivo, this);
	}

	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
	    return this.faseAtual.getMinutosAtraso(this);
	}

	public void apresentarPraLargada() throws AtividadeNaoPermitidaException, AtividadeNaoPrecisaDeAlteracaoException {
	    this.faseAtual.apresentarPraLargada(this);
	}

	public void registrarLargada() throws AtividadeNaoPermitidaException {
	    this.faseAtual.registrarLargada(this);
	}

	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
	    this.faseAtual.registrarChegada(tempo, this);
	}

	public void setFaseAtual(StateProva faseAtual) {
		this.faseAtual = faseAtual;
	}	

	public void adicionarAtrasoNaChegada(Duration atraso) {
    	Duration chegada = this.getTempo(Prisma.CHEGADA);
    	if (chegada != null && atraso != null && !atraso.isZero()) {
        	this.passagens.atualizarTempo(Prisma.CHEGADA, chegada.plus(atraso));
    	}
	}
}
