package br.ifba.ads.inf011.anotherModel;

import br.ifba.ads.inf011.framework.Application;
import br.ifba.ads.inf011.framework.Document;

public class AnotherApplication extends Application{
	
	public AnotherApplication() {
		super();
	}

	@Override
	protected Document createDocument(String name) {
		return new AnotherDocument(name);
	}

}
