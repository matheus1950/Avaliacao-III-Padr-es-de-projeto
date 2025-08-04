package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.chain.RegraApuracao;
import br.ifba.edu.aval.exception.DNFException;

public class Apurador {
    private RegraApuracao regraInicial;

    public Apurador(RegraApuracao regraInicial) {
        this.regraInicial = regraInicial;
    }

    public Duration apurar(BoletimProva boletim) throws DNFException {
        regraInicial.aplicar(boletim);
        return boletim.getTempo(Prisma.CHEGADA);
    }
}
