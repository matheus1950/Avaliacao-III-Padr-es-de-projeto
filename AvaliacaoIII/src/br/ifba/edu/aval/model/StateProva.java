package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.AtividadeNaoPrecisaDeAlteracaoException;

public interface StateProva {
    void registrar(Integer prismaID, Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException;
    void registrarAtrasoPartida(Long minutoEfetivo, BoletimProva boletim) throws AtividadeNaoPermitidaException;
    Long getMinutosAtraso(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException, AtividadeNaoPrecisaDeAlteracaoException;
    void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    void registrarChegada(Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException;
}