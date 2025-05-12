package br.ifba.ads.inf011;

import java.util.List;

public class HTMLReader {
	
	private TextConverter builder;
	

	public HTMLReader(TextConverter builder) {
		this.builder = builder;
	}
	
	public void parse(String html) {
		
		List<Token> tokens = new HTMLParse(html).parse();
		
		for(Token token : tokens) {
			switch(token.tipo()) {
				case TipoToken.CHAR : this.builder.convertChar(token.conteudo().charAt(0)); break;
				case TipoToken.BOLD : this.builder.convertBold(); break;
				case TipoToken.ITALIC : this.builder.convertItalic(); break;
				case TipoToken.PARA : this.builder.convertParagraph(); break;
			}
		}	
	}
	

}
