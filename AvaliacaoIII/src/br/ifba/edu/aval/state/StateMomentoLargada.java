package br.ifba.edu.aval.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class StateMomentoLargada implements StateProva {

    public void registrar(Integer prismaID, Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar prisma no Momento da Largada.");
    }

    public void registrarAtrasoPartida(Long minutoEfetivo, BoletimProva boletim) {
        boletim.minutoPartidaEfetivo = minutoEfetivo;
    }

    public Long getMinutosAtraso(BoletimProva boletim) {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }

    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Atividade não precisa de alteração — já está no momento de largada");
    }

    public void registrarLargada(BoletimProva boletim) {
        boletim.setFaseAtual(new StatePista());
    }

    public void registrarChegada(Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar chegada no Momento da Largada.");
    }
}
