package br.ifba.edu.aval1.builder;

import br.ifba.edu.aval1.model.Dificuldade;
import br.ifba.edu.aval1.model.Idade;
import br.ifba.edu.aval1.model.PontoGeografico;
import br.ifba.edu.aval1.model.Prisma;
import br.ifba.edu.aval1.model.Sexo;

public interface OrientacaoBuilder {
	
	public void init();
	public void withSexo(Sexo sexo);
	public void withIdade(Idade categoria);
	public void withDificuldade(Dificuldade dificuldade);
	public void withPartidaAt(PontoGeografico partida);
	public void withLargadaAt(PontoGeografico largada);
	public void withChegadaAt(PontoGeografico chegada);
	public void addPrisma(Prisma prisma);
	public void setECN(Integer i);
	public void setEscala(Integer i);

}
