package br.ifba.ads.inf011;

public class ContadorCaracteres implements TextConverter{
	
	private Integer caracteres;
	
	public ContadorCaracteres() {
		this.caracteres = 0;
	}

	@Override
	public void convertChar(char charAt) {
		this.caracteres++;
	}

	@Override
	public void convertParagraph() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertBold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertItalic() {
		// TODO Auto-generated method stub
		
	}

	
	public Integer quantidade() {
		return this.caracteres;
	}
}
