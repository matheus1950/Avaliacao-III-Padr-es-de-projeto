package br.ifba.ads.inf011.motif;

import br.ifba.ads.inf011.Widget;
import br.ifba.ads.inf011.WidgetFactory;

public class MotifWidgetFactory implements WidgetFactory{

	@Override
	public Widget create(int tipo) {
		switch(tipo) {
			case 1: return new MotifWindow();
			case 2: return new MotifScrollBar();
			case 3: return new MotifButton();
			case 4: return new MotifCheckBox();
		}
		return null;
	}

}
