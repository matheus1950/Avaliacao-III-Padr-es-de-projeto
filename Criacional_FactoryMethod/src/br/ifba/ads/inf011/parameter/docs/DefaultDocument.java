package br.ifba.ads.inf011.parameter.docs;

import br.ifba.ads.inf011.framework.Document;

public class DefaultDocument extends Document {
	
	public DefaultDocument(String name) {
		super(name);
	}

	@Override
	public void open() {
		System.out.println("Open de AlternativeDocument " + this.getName() + "...");
	}

	@Override
	public void close() {
		System.out.println("Close de AlternativeDocument " + this.getName() + "...");
	}

}
