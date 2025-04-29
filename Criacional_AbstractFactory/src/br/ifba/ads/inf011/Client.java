package br.ifba.ads.inf011;

import br.ifba.ads.inf011.pm.PMWidgetFactory;

public class Client {
	
	private WidgetFactory widgetFactory;
	
	
	public Client(WidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;
	}
	
	public void draw() {
		Window window = this.widgetFactory.createWindow();
		ScrollBar scrollBar = this.widgetFactory.createScrollBar();
		window.draw();
		scrollBar.draw();
	}
	
	
	public static void main(String[] args) {
		new Client(new PMWidgetFactory()).draw();
	}
	
	
	

}
