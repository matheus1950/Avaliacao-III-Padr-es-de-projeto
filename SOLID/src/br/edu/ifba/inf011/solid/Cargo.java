package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;

public enum Cargo {
	
	ESTAGIARIO(new BigDecimal("5000")),
	TRAINEE(new BigDecimal("10000")),
	JUNIOR(new BigDecimal("20000")),
	PLENO(new BigDecimal("30000")),
	SENIOR(new BigDecimal("40000")), 
	MENTOR(new BigDecimal("50000"));
	
	Cargo(BigDecimal tetoSalarial){
		this.tetoSalarial = tetoSalarial;
	}
	
	BigDecimal tetoSalarial;
	
	public BigDecimal getTetoSalarial() {
		return this.tetoSalarial;
	}
	
	 public Cargo next() {
		 Cargo[] cargos = Cargo.values();
	     int nextOrdinal = this.ordinal() + 1;
        if (nextOrdinal >= cargos.length) {
        	return this;
	    }
        return cargos[nextOrdinal];
    }

}