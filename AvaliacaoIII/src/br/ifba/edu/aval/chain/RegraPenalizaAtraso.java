package br.ifba.edu.aval.chain;

import java.time.Duration;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.exception.DNFException;

public class RegraPenalizaAtraso extends RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim) throws DNFException {
        Duration atraso = boletim.getTempoAtraso();
        if (atraso != null) {
            Duration tempo = boletim.getTempo(Prisma.CHEGADA);
            boletim.setTempo(Prisma.CHEGADA, tempo.plus(atraso));
        }
        super.aplicar(boletim);
    }
}
