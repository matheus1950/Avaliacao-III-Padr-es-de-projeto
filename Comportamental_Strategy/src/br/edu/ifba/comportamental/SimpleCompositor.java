package br.edu.ifba.comportamental;

public class SimpleCompositor implements  Compositor {

	@Override
	 public String compose(String text) {
		
		
		
	     System.out.println("--- Formatando com SimpleCompositor (quebra a cada 40 chars) ---");
		 // Lógica simples para quebrar a linha a cada 40 caracteres
		 StringBuilder result = new StringBuilder();
		 for (int i = 0; i < text.length(); i += 40) {
		     int end = Math.min(i + 40, text.length());
		     result.append(text.substring(i, end)).append("\n");
	     }
	     return result.toString();
	 }
}