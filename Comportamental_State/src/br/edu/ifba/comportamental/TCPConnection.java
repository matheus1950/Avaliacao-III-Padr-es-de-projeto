package br.edu.ifba.comportamental;

public class TCPConnection {
    private TCPState currentState;

    public TCPConnection() {
        System.out.println("Nova conexão TCP criada. Estado inicial: Fechada.");
        this.currentState = new TCPClosed();
    }

    public void setState(TCPState state) {
        this.currentState = state;
    }

    public void open() {
    	this.currentState =  this.currentState.open();
    }

    public void close() {
    	this.currentState =  this.currentState.close();
    }

    public void receive() {
    	this.currentState.receiveAck();
    }
    
    public void send() {
    	this.currentState.send();
    }    
}
