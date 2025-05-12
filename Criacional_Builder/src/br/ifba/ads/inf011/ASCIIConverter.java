package br.ifba.ads.inf011;

public class ASCIIConverter implements TextConverter{
	
	private StringBuilder str;
	
	 public ASCIIConverter() {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertItalic() {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getASCII() {
		return this.str.toString();
	}

}
