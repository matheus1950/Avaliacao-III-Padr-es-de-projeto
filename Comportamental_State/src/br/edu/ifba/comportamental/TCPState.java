package br.edu.ifba.comportamental;

public interface TCPState {
   public TCPState open();
   public TCPState close();
   public void send();
   public void receiveAck();
}
