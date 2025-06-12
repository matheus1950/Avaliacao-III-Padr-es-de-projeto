package br.edu.ifba.comportamental;

public class App {
	
	
    public void run() {
        String textoExemplo = "Existem muitos algoritmos para quebrar um stream de texto em linhas. " +
                              "Codificar de maneira fixa e rígida tais algoritmos nas classes que os " +
                              "utilizam não é desejável por várias razões. Podemos evitar esses problemas " +
                              "definindo classes que encapsulam diferentes algoritmos de quebra de linhas.";

        Composition composition = new Composition(textoExemplo, "Assinado por: App.main");

        composition.setCompositor(new SimpleCompositor());
        composition.reformat();

        composition.setCompositor(new TeXCompositor());
        composition.reformat();

        composition.setCompositor(new ArrayCompositor(7)); // Quebrar a cada 7 palavras
        composition.reformat();
        
        composition.setCompositor(new JustifiedCompositor(50)); 
        composition.reformat();

        
    }
    
    
    
    public static void main(String[] args) {
		new App().run();
	}
}
