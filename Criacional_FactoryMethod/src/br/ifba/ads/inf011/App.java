package br.ifba.ads.inf011;

import br.ifba.ads.inf011.anotherModel.AnotherApplication;
import br.ifba.ads.inf011.framework.Application;

public class App {
	
	private Application myApp;
	
	public App(Application myApp) {
		this.myApp = myApp;
	}
	
	
	public void run() {
		this.myApp.newDocument("Document1");
		this.myApp.newDocument("Document2");
		this.myApp.openDocument("Document2");
		this.myApp.openDocument("Document3");
	}
	
	
	public static void main(String[] args) {
		new App(new AnotherApplication()).run(); 
	}
	

}
