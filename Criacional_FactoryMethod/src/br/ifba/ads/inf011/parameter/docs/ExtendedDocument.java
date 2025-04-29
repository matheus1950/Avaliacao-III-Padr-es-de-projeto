package br.ifba.ads.inf011.parameter.docs;

import br.ifba.ads.inf011.framework.Document;

public class ExtendedDocument extends Document {

	public ExtendedDocument(String name) {
		super(name);
	}	
	
	@Override
	public void open() {
		System.out.println("Open de ExtendedDocument " + this.getName() + "...");
	}

	@Override
	public void close() {
		System.out.println("Close de ExtendedDocument " + this.getName() + "...");
	}


}
