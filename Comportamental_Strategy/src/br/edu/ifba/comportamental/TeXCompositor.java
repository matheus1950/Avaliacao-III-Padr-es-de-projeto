package br.edu.ifba.comportamental;

public class TeXCompositor implements Compositor {
	 @Override
	 public String compose(String text) {
	     System.out.println("--- Formatando com TeXCompositor (otimização de parágrafo) ---");
	     return text.replaceAll("\\.", ".  \n"); // Exemplo simples
	 }
}