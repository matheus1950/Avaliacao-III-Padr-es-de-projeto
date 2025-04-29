package br.ifba.ads.inf011;

import br.ifba.ads.inf011.parameter.app.ExtendedParameterApplication;
import br.ifba.ads.inf011.parameter.app.ParameterApplication;
import br.ifba.ads.inf011.parameter.doctypes.BasicDocumentType;
import br.ifba.ads.inf011.parameter.doctypes.ExtendedDocumentType;

public class AppExtendedParameter {
	
	private ParameterApplication myApp;
	
	public AppExtendedParameter(ParameterApplication myApp) {
		this.myApp = myApp;
	}
	
	
	public void run() {
		this.myApp.newDocument("Document1", BasicDocumentType.AlternativeDocument);
		this.myApp.newDocument("Document2", ExtendedDocumentType.ParticularDocument);
		this.myApp.openDocument("Document2");
		this.myApp.openDocument("Document3");
	}
	
	
	public static void main(String[] args) {
		new AppExtendedParameter(new ExtendedParameterApplication()).run(); 
		
	}
	

}
