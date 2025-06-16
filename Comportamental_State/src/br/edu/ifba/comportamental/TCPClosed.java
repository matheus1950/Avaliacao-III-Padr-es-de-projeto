package br.edu.ifba.comportamental;

public class TCPClosed implements TCPState {

    @Override
    public TCPState open() {
        System.out.println("Estado Closed: Abrindo uma nova conexão... Agora escutando.");
        return new TCPListen();
    }

    @Override
    public TCPState close() {
        System.out.println("Estado Closed: A conexão já está fechada.");
        return this;
    }

	@Override
	public void send() {
        System.out.println("Estado Closed: Envio não é aplicável. A conexão está fechada. Lançar exceção.");
	}

	@Override
	public void receiveAck() {
        System.out.println("Estado Closed: Acknowledge não é aplicável. A conexão está fechada. Lançar exceção.");
	}
}
