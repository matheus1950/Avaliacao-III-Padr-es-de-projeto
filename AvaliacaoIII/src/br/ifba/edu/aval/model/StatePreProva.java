package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class StatePreProva implements StateProva {

    public void registrar(Integer prismaID, Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar prisma na Pré-Prova.");
    }

    public void registrarAtrasoPartida(Long minutoEfetivo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar atraso na Pré-Prova.");
    }

    public Long getMinutosAtraso(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode obter atraso na Pré-Prova.");
    }

    public void apresentarPraLargada(BoletimProva boletim) {
        boletim.setFaseAtual(new StateMomentoLargada());
    }

    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar largada na Pré-Prova.");
    }

    public void registrarChegada(Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar chegada na Pré-Prova.");
    }
}
