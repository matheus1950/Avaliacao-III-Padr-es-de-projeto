package br.ifba.ads.inf011.motif;

import br.ifba.ads.inf011.ScrollBar;
import br.ifba.ads.inf011.WidgetFactory;
import br.ifba.ads.inf011.Window;

public class MotifWidgetFactory implements WidgetFactory{

	@Override
	public ScrollBar createScrollBar() {
		return new MotifScrollBar();
	}

	@Override
	public Window createWindow() {
		return new MotifWindow();
	}

}
