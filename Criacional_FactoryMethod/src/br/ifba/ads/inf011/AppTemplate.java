package br.ifba.ads.inf011;

import br.ifba.ads.inf011.anotherModel.AnotherDocument;
import br.ifba.ads.inf011.framework.ApplicationTemplate;

public class AppTemplate {
	
	private ApplicationTemplate<AnotherDocument> myApp;
	
	public AppTemplate() {
		this.myApp = new ApplicationTemplate<AnotherDocument>();
	}
	
	
	public void run() throws Exception {
		this.myApp.newDocument("Document1", AnotherDocument.class);
		this.myApp.newDocument("Document2", AnotherDocument.class);
		this.myApp.openDocument("Document2");
		this.myApp.openDocument("Document3");
	}
	
	
	public static void main(String[] args) throws Exception {
		new AppTemplate().run(); 
	}
	

}
