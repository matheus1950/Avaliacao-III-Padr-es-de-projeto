package br.ifba.edu.aval.chain;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.exception.DNFException;

public abstract class RegraApuracao {
    protected RegraApuracao proxima;

    public void setProxima(RegraApuracao proxima) {
        this.proxima = proxima;
    }

    public void aplicar(BoletimProva boletim) throws DNFException {
        if (proxima != null) proxima.aplicar(boletim);
    }
}
