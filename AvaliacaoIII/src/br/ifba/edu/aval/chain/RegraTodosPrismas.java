package br.ifba.edu.aval.chain;

import java.util.List;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.exception.DNFException;

public class RegraTodosPrismas extends RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim) throws DNFException {
        List<Integer> ordem = boletim.getOrdemPrismas();
        for (Integer prisma : ordem) {
            if (prisma != Prisma.CHEGADA && boletim.getTempo(prisma) == null) {
                throw new DNFException("Prisma não registrado: " + prisma);
            }
        }
        super.aplicar(boletim);
    }
}
