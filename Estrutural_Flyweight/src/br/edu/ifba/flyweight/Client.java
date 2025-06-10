package br.edu.ifba.flyweight;

public class Client {
	
	public void run() {
        String texto = "Uma String muito grande e que poderia gerar um consumo enorme de memoria se armazenassemos os glyphs repetidos em cada um deles!";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            CaractereClient caractere = new CaractereClient(c, "Arial", 12, i*10); // Reutiliza o mesmo caractere
            caractere.exibir(); 
        }

        
        System.out.println("Número de caracteres na string: " + texto.length());
        System.out.println("Número de objetos CaractereConcreteFlyweight criados: " + CaractereFlyweightFactory.poolSize());

    }	
	
	
	public static void main(String[] args) {
		new Client().run();
	}

}
