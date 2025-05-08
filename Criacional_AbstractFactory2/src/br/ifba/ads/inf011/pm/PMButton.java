package br.ifba.ads.inf011.pm;

import br.ifba.ads.inf011.Button;

public class PMButton implements Button {

	@Override
	public void action() {
		System.out.println("Action em um Presentation Manager Button");
	}

}
