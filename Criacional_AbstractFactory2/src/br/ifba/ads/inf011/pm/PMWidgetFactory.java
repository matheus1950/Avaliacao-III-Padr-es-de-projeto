package br.ifba.ads.inf011.pm;

import br.ifba.ads.inf011.Button;
import br.ifba.ads.inf011.ScrollBar;
import br.ifba.ads.inf011.Widget;
import br.ifba.ads.inf011.WidgetFactory;
import br.ifba.ads.inf011.Window;
import br.ifba.ads.inf011.motif.MotifButton;
import br.ifba.ads.inf011.motif.MotifScrollBar;
import br.ifba.ads.inf011.motif.MotifWindow;

public class PMWidgetFactory implements WidgetFactory{

	@Override
	public Widget create(int tipo) {
		switch(tipo) {
			case 1: return new PMWindow();
			case 2: return new PMScrollBar();
			case 3: return new PMButton();
		}
		return null;
	}	

}
