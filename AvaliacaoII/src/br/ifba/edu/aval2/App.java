package br.ifba.edu.aval2;

import java.time.Duration;

import br.ifba.edu.aval1.builder.ListaPassagensBuilder;
import br.ifba.edu.aval1.builder.MapaBuilder;
import br.ifba.edu.aval1.builder.OrientacaoDirector;
import br.ifba.edu.aval1.builder.SinaleticaBuilder;
import br.ifba.edu.aval1.model.BoletimProva;
import br.ifba.edu.aval1.model.Dificuldade;
import br.ifba.edu.aval1.model.Idade;
import br.ifba.edu.aval1.model.Mapa;
import br.ifba.edu.aval1.model.Sexo;
import br.ifba.edu.aval1.model.Sinaletica;
import br.ifba.edu.aval1.prototype.BoletimProvaFactory;
import br.ifba.edu.aval2.bridge.ExportadorMapa;
import br.ifba.edu.aval2.bridge.ExportadorMapaSimplificado;
import br.ifba.edu.aval2.bridge.GeradorMapaSVG;
import br.ifba.edu.aval2.decorator.GeradorMapaComMarcaDagua;

public class App {
	
	public void aval1() {
		this.run();
		System.out.println("******************************************");
		this.run2();
		System.out.println("******************************************");
		this.run3();
		System.out.println("******************************************");
	}
	
	public void aval2() {
		this.run4(new ExportadorMapaSimplificado(new GeradorMapaSVG()));
		System.out.println("******************************************");
		this.run4(new ExportadorMapaSimplificado(new GeradorMapaComMarcaDagua(new GeradorMapaSVG())));
		
	}	
	
	
	public void run() {
		MapaBuilder builder = new MapaBuilder();
		OrientacaoDirector director = new OrientacaoDirector(builder);
		director.makePercurso01();
		Mapa mapa = builder.get();
		System.out.println(mapa);
	}
	
	public void run2() {
		SinaleticaBuilder builder = new SinaleticaBuilder();
		OrientacaoDirector director = new OrientacaoDirector(builder);
		director.makePercurso01();
		Sinaletica sinaletica= builder.get();
		System.out.println(sinaletica);
	}	
	
	
	public void run3() {
		ListaPassagensBuilder builder = new ListaPassagensBuilder();
		OrientacaoDirector director = new OrientacaoDirector(builder);
		director.makePercurso01();
		builder.make();
		
		BoletimProva atleta1 = BoletimProvaFactory.instance().getBoletim("12000", Sexo.D, Idade.INFANTIL, Dificuldade.N); 
		BoletimProva atleta2 = BoletimProvaFactory.instance().getBoletim("13000", Sexo.D, Idade.INFANTIL, Dificuldade.N);		
		
		atleta1.registrar(31, Duration.ofSeconds(60));
		atleta1.registrar(32, Duration.ofSeconds(80));
		atleta1.registrar(33, Duration.ofSeconds(100));
		atleta1.registrar(34, Duration.ofSeconds(150));

		atleta2.registrar(31, Duration.ofSeconds(55));
		atleta2.registrar(32, Duration.ofSeconds(95));
		atleta2.registrar(33, Duration.ofSeconds(125));
		atleta2.registrar(34, Duration.ofSeconds(160));
		
		System.out.println(atleta1);
		System.out.println(atleta2);
		
		
	}	
	
	
	public void run4(ExportadorMapa exportador) {
		MapaBuilder builder = new MapaBuilder();
		OrientacaoDirector director = new OrientacaoDirector(builder);
		director.makePercurso01();
		Mapa mapa = builder.get();
		System.out.println("*** GERAÇÃO DE MAPA SIMPLIFICADO EM SVG ***");
        System.out.println(exportador.exportar(mapa));		
	}	
	
	
	public static void main(String[] args) {
		new App().aval2();
	}

}
