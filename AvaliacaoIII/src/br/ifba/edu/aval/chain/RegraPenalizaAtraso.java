package br.ifba.edu.aval.chain;

import java.time.Duration;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.exception.DNFException;

public class RegraPenalizaAtraso extends RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim) throws DNFException {
        try {
            Long atrasoMinutos = boletim.getMinutosAtraso();
            if (atrasoMinutos != null && atrasoMinutos > 0) {
                Duration atraso = Duration.ofMinutes(atrasoMinutos);
                boletim.adicionarAtrasoNaChegada(atraso);
                System.out.println(boletim.cboNumero() + " penalizado com " + atraso.toMinutes() + " minutos de atraso");
            }
        } catch (Exception e) {
            throw new DNFException("Erro ao aplicar penalização de atraso: " + e.getMessage());
        }
        super.aplicar(boletim);
    }
}
