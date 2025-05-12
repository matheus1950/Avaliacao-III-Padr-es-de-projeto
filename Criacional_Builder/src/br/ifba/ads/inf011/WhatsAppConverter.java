package br.ifba.ads.inf011;

public class WhatsAppConverter implements TextConverter{
	
	private StringBuilder str;
	
	 public WhatsAppConverter() {
		 this.str = new StringBuilder();
	 }
	
	
	@Override
	public void convertChar(char charAt) {
		this.str.append(charAt);
	}


	@Override
	public void convertParagraph() {
		this.str.append('\n');
	}

	@Override
	public void convertBold() {
		this.str.append('*');
		
	}

	@Override
	public void convertItalic() {
		this.str.append('_');
	}
	
	
	public String getASCII() {
		return this.str.toString();
	}

}
