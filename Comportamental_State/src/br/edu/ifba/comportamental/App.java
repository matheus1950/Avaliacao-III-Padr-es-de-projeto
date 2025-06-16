package br.edu.ifba.comportamental;

public class App {
	
	
    public void run() {
    	
	    TCPConnection connection = new TCPConnection();
	    System.out.println("---");
	    connection.close();
	    connection.send();
	    connection.receive();
	    System.out.println("---");
	
	    // Abrindo a conexão. Ela irá para o estado Listen
	    connection.open();
	    connection.send();
	    connection.receive();
	    System.out.println("---");
	
	    // Tentando abrir de novo (agora no estado Listen, mudará para Established)
	    connection.open();
	    System.out.println("---");
	
	    // Enviando dados na conexão estabelecida
	    connection.send();
	    connection.receive();
	    System.out.println("---");
	
	    // Tentando abrir uma conexão já estabelecida (ação ignorada)
	    connection.open();
	    connection.send();
	    connection.receive();
	    System.out.println("---");
	    
	    // Fechando a conexão
	    connection.close();
	    System.out.println("---");
	
	    // Tentando enviar dados em uma conexão agora fechada
	    connection.send();
	    connection.receive();
}
    
    
    
    public static void main(String[] args) {
		new App().run();
	}
}
