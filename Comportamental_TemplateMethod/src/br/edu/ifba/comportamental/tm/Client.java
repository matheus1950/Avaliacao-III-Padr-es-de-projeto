package br.edu.ifba.comportamental.tm;

public class Client {
	
	
	public void run(Application app) throws Exception {
		
        try {
        	app.openDocument("arquivo1.draw");
        	app.openDocument("arquivo2.draw");
        	app.openDocument("texto.txt"); // Este será rejeitado por canOpenDocument
        }catch(Exception ex) {
        	System.err.println(ex.toString());
        }
		
	}
	
	public static void main(String[] args) throws Exception {
		new Client().run(new DrawingApplication());
	}

}
