package br.ifba.ads.inf011.anotherModel;

import br.ifba.ads.inf011.framework.Document;

public class AnotherDocument extends Document {
	
	public AnotherDocument(String name) {
		super(name);
	}

	@Override
	public void open() {
		System.out.println("Open de AnotherDocument " + this.getName() + "...");
	}

	@Override
	public void close() {
		System.out.println("Close de AnotherDocument " + this.getName() + "...");
	}

}
