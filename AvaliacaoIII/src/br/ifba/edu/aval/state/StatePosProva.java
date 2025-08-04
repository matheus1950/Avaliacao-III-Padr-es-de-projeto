package br.ifba.edu.aval.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class StatePosProva implements StateProva {

    public void registrar(Integer prismaID, Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar prisma na Pós-Prova.");
    }

    public void registrarAtrasoPartida(Long minutoEfetivo, BoletimProva boletim) {
        boletim.minutoPartidaEfetivo = minutoEfetivo;
    }

    public Long getMinutosAtraso(BoletimProva boletim) {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }

    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Prova já finalizada.");
    }

    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar largada na Pós-Prova.");
    }

    public void registrarChegada(Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Chegada já registrada.");
    }
}
