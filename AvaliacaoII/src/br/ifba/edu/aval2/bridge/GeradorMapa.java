package br.ifba.edu.aval2.bridge;

import java.util.Collection;

import br.ifba.edu.aval1.model.Mapa;
import br.ifba.edu.aval1.model.PontoGeografico;
import br.ifba.edu.aval1.model.Prisma;

public interface GeradorMapa {
    public String iniciarDocumento() ;
    public String adicionarAreaMapa(Mapa mapa);
    public String adicionarMetadados(String categoria);
    public String adicionarPonto(String tipo, PontoGeografico ponto);
    public String adicionarTexto(PontoGeografico ponto, String texto);
    public PontoGeografico referenciaMin(Collection<Prisma> prismas);
    public PontoGeografico referenciaMax(Collection<Prisma> prismas);
    public String finalizarDocumento();
}
