package br.ifba.ads.inf011.myModel;

import br.ifba.ads.inf011.framework.Application;
import br.ifba.ads.inf011.framework.Document;

public class MyApplication extends Application{
	
	public MyApplication() {
		super();
	}

	@Override
	protected Document createDocument(String name) {
		return new MyDocument(name);
	}

}
