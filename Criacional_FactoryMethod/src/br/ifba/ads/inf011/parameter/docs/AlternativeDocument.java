package br.ifba.ads.inf011.parameter.docs;

import br.ifba.ads.inf011.framework.Document;

public class AlternativeDocument extends Document {
	
	public AlternativeDocument(String name) {
		super(name);
	}

	@Override
	public void open() {
		System.out.println("Open de DefaultDocument " + this.getName() + "...");
	}

	@Override
	public void close() {
		System.out.println("Close de DefaultDocument " + this.getName() + "...");
	}

}
