package br.ifba.edu.aval.chain;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.exception.DNFException;

public class RegraOrdemPrismas extends RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim) throws DNFException {
        List<Integer> ordem = boletim.getOrdemPrismas();
        for (int i = 0; i < ordem.size() - 1; i++) {
            Duration anterior = boletim.getTempo(ordem.get(i));
            Duration atual = boletim.getTempo(ordem.get(i + 1));
            if (anterior != null && atual != null && anterior.compareTo(atual) > 0) {
                throw new DNFException("Prismas fora de ordem");
            }
        }
        super.aplicar(boletim);
    }
}
