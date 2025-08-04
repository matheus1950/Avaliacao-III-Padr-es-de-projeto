package br.ifba.edu.aval.chain;

import java.time.Duration;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.exception.DNFException;

public class RegraTempoMaximo extends RegraApuracao {
    private Duration tempoMaximo;

    public RegraTempoMaximo(Duration tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }

    @Override
    public void aplicar(BoletimProva boletim) throws DNFException {
        Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
        if (tempoChegada != null && tempoChegada.compareTo(tempoMaximo) > 0) {
            throw new DNFException("Tempo máximo excedido");
        }
        super.aplicar(boletim);
    }
}
