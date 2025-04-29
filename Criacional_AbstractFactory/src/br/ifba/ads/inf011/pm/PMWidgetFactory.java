package br.ifba.ads.inf011.pm;

import br.ifba.ads.inf011.ScrollBar;
import br.ifba.ads.inf011.WidgetFactory;
import br.ifba.ads.inf011.Window;

public class PMWidgetFactory implements WidgetFactory{

	@Override
	public ScrollBar createScrollBar() {
		return new PMScrollBar();
	}

	@Override
	public Window createWindow() {
		return new PMWindow();
	}

}
