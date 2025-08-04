package br.ifba.edu.aval.chain;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.exception.DNFException;

public class RegraChegada extends RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim) throws DNFException {
        if (boletim.getTempo(Prisma.CHEGADA) == null) {
            throw new DNFException("Atleta não registrou chegada");
        }
        super.aplicar(boletim);
    }
}
