package br.ifba.edu.aval1.builder;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval1.model.Dificuldade;
import br.ifba.edu.aval1.model.Idade;
import br.ifba.edu.aval1.model.Mapa;
import br.ifba.edu.aval1.model.PontoGeografico;
import br.ifba.edu.aval1.model.Prisma;
import br.ifba.edu.aval1.model.Sexo;

public class MapaBuilder implements OrientacaoBuilder{
	
	private Sexo sexo;
	private Idade idade;
	private Dificuldade dificuldade;
	private Integer escala;
	private Integer ecn;
	private PontoGeografico largada;
	private PontoGeografico partida;
	private List<Prisma> prismas; 
	private PontoGeografico chegada;	
	
	public void init() {
		this.sexo = Sexo.D;
		this.idade = Idade.INFANTIL;
		this.dificuldade = Dificuldade.N;
		this.largada = null;
		this.partida = null;
		this.chegada = null;
		this.escala = 7500;
		this.ecn = 5;
		this.prismas = new ArrayList<Prisma>();
	}

	@Override
	public void withSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public void withIdade(Idade idade) {
		this.idade = idade;
	}
	
	@Override
	public void withDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}	

	@Override
	public void withPartidaAt(PontoGeografico partida) {
		this.partida = partida;
	}

	@Override
	public void withLargadaAt(PontoGeografico largada) {
		this.largada = largada;
	}

	@Override
	public void withChegadaAt(PontoGeografico chegada) {
		this.chegada = chegada;
	}

	@Override
	public void addPrisma(Prisma prisma) {
		this.prismas.add(prisma);
	}
	
	public void setEscala(Integer escala) {
		this.escala = escala;
	}
	
	public void setECN(Integer eqn) {
		this.ecn = ecn;
	}
	
	public Mapa get() {

		PontoGeografico origem = null;
		
		if(this.partida == null && this.largada!= null)
			origem = this.largada;
		if(this.partida != null && this.largada== null)
			origem = this.partida;

		if(this.partida == null)
			this.partida = origem;
		if(this.largada == null)
			this.largada = origem;
		if(this.chegada == null)
			this.chegada = largada;
		
		return new Mapa(this.sexo, this.idade, this.dificuldade, 
						this.escala, this.ecn, largada, this.partida,
						this.prismas, this.chegada);
	}


	

}
