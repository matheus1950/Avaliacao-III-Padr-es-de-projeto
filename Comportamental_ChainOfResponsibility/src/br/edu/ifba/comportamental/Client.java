package br.edu.ifba.comportamental;

public class Client {
	
	public void run() {
		Integer helpArea = 1;
        PrintButton button = new PrintButton(new PrintDialog(new Application(null)));
        button.handleHelp(helpArea); 
    }
	
    public static void main(String[] args) {
    	new Client().run();
    }
}