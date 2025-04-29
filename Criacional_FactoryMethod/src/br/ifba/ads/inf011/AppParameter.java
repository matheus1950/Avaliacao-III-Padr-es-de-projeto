package br.ifba.ads.inf011;

import br.ifba.ads.inf011.parameter.app.ParameterApplication;
import br.ifba.ads.inf011.parameter.doctypes.BasicDocumentType;

public class AppParameter {
	
	private ParameterApplication myApp;
	
	public AppParameter(ParameterApplication myApp) {
		this.myApp = myApp;
	}
	
	
	public void run() {
		this.myApp.newDocument("Document1", BasicDocumentType.AlternativeDocument);
		this.myApp.newDocument("Document2", BasicDocumentType.DefaultDocument);
		this.myApp.openDocument("Document2");
		this.myApp.openDocument("Document3");
	}
	
	
	public static void main(String[] args) {
		new AppParameter(new ParameterApplication()).run(); 
		
	}
	

}
