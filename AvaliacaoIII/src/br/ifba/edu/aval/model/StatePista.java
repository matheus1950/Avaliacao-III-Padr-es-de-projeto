package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class StatePista implements StateProva {

    public void registrar(Integer prismaID, Duration tempo, BoletimProva boletim) {
        boletim.passagens.registrarPassagem(prismaID, tempo);
    }

    public void registrarAtrasoPartida(Long minutoEfetivo, BoletimProva boletim) {
        boletim.minutoPartidaEfetivo = minutoEfetivo;
    }

    public Long getMinutosAtraso(BoletimProva boletim) {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }

    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Já passou da fase de apresentação.");
    }

    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Largada já registrada.");
    }

    public void registrarChegada(Duration tempo, BoletimProva boletim) {
        boletim.passagens.registrarPassagem(Prisma.CHEGADA, tempo);
        boletim.setFaseAtual(new StatePosProva());
    }
}

