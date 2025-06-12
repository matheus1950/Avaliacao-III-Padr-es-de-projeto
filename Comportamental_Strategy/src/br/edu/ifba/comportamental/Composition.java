package br.edu.ifba.comportamental;

public class Composition {
	 private Compositor compositor;
	 private final String textContent;
	 private final String assinatura;

	 public Composition(String textContent, String assinatura) {
	     this.textContent = textContent;
	     this.assinatura = assinatura;
	 }

	 public void setCompositor(Compositor compositor) {
	     this.compositor = compositor;
	 }

	 public void reformat() {
	     if (compositor == null) {
	         System.out.println("Erro: Nenhuma estratégia de composição foi definida.");
	         return;
	     }
	     String formattedText = compositor.compose(this.textContent) + "\n" + this.assinatura;
	     System.out.println("Resultado da Composição:\n" + formattedText);
	     System.out.println("-------------------------------------\n");
	 }
}