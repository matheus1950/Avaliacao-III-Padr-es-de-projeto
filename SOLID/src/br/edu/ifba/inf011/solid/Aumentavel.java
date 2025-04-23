package br.edu.ifba.inf011.solid;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Aumentavel {
	public LocalDate getDtAdmissao();
	public Cargo getCargo();
	public BigDecimal getSalario();
	public void aumentarSalario(BigDecimal novoSalario);	
}
