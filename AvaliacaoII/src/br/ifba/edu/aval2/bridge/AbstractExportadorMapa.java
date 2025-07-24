package br.ifba.edu.aval2.bridge;

import br.ifba.edu.aval1.model.Mapa;

public abstract class AbstractExportadorMapa implements ExportadorMapa{
	
	protected GeradorMapa gerador; 

    public AbstractExportadorMapa(GeradorMapa gerador) {
        this.gerador = gerador;
    }
    
}
