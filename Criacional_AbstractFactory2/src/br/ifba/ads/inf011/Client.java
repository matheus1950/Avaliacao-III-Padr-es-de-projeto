package br.ifba.ads.inf011;

import br.ifba.ads.inf011.pm.PMWidgetFactory;

public class Client {
	
	private WidgetFactory widgetFactory;
	
	
	public Client(WidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;
	}
	
	public void draw() {
		Window window = (Window) this.widgetFactory.create(1);
		ScrollBar scrollBar = (ScrollBar) this.widgetFactory.create(2);
		Button button = (Button) this.widgetFactory.create(3); 
		window.draw();
		scrollBar.roll();
		button.action();
		
		CheckBox cb = (CheckBox) this.widgetFactory.create(4);
		cb.click();
//		Widget window = this.widgetFactory.create(1);
	}
	
	
	public static void main(String[] args) {
		new Client(new PMWidgetFactory()).draw();
	}
	
	
	

}
