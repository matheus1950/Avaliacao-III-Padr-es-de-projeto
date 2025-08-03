package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;

public class Apurador {
	
	private Duration tempoMaximo;
	
	public Apurador(Duration tempoMaximoProva) {
		this.tempoMaximo = tempoMaximoProva;
	}
	
	public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
		Duration tempoProva = Duration.ZERO;
    	List<Integer> ordemPrismas = boletim.getOrdemPrismas();
		
    	tempoProva = boletim.getTempo(Prisma.CHEGADA);
    	if(tempoProva == null)
    		throw new DNFException("Atleta não registrou chegada");
   		if(tempoProva.compareTo(this.tempoMaximo) > 0)
   			throw new DNFException("O atleta finalizou a prova, após o tempo limite");
    	for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
    		Duration anterior = boletim.getTempo(ordemPrismas.get(iCont));
    		Duration atual = boletim.getTempo(ordemPrismas.get(iCont+1));
    		if(anterior != null && atual != null)
    			if(anterior.compareTo(atual) > 0)
    				throw new DNFException("Atleta registrou prisma fora da ordem");
    	}
       	for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
       		Duration tempo = boletim.getTempo(ordemPrismas.get(iCont));
       		if(ordemPrismas.get(iCont) != Prisma.CHEGADA && tempo == null)
       			throw new DNFException("Atleta não registrou um dos prismas.");
       	}	
    	tempoProva = tempoProva.plus(Duration.ofMinutes(boletim.getMinutosAtraso()));
    	return tempoProva;
	}	
}
