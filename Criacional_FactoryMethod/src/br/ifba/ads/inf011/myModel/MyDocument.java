package br.ifba.ads.inf011.myModel;

import br.ifba.ads.inf011.framework.Document;

public class MyDocument extends Document {
	
	public MyDocument(String name) {
		super(name);
	}

	@Override
	public void open() {
		System.out.println("Open de MyDocument " + this.getName() + "...");
	}

	@Override
	public void close() {
		System.out.println("Close de MyDocument " + this.getName() + "...");
	}

}
