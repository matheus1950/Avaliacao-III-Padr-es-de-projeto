package br.ifba.ads.inf011;

public class Client {

	
	public void run3() {
		ContadorCaracteres converter = new ContadorCaracteres();
		String html = "Este é um texto <b>negrito</b> e <i>itálico</i>.<p>Um parágrafo.</p><br>Quebra.";
		HTMLReader reader = new HTMLReader(converter);
		reader.parse(html);
		System.out.println(converter.quantidade());
	}	
	
	
	public void run2() {
		ASCIIConverter converter = new ASCIIConverter();
		String html = "Este é um texto <b>negrito</b> e <i>itálico</i>.<p>Um parágrafo.</p><br>Quebra.";
		HTMLReader reader = new HTMLReader(converter);
		reader.parse(html);
		System.out.println(converter.getASCII());
	}	
	
	public void run() {
		WhatsAppConverter converter = new WhatsAppConverter();
		String html = "Este é um texto <b>negrito</b> e <i>itálico</i>.<p>Um parágrafo.</p><br>Quebra.";
		HTMLReader reader = new HTMLReader(converter);
		reader.parse(html);
		System.out.println(converter.getASCII());
	}
	
	
	public static void main(String[] args) {
		new Client().run();
		new Client().run2();
		new Client().run3();
	}

}
