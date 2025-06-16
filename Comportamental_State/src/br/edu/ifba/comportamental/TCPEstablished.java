package br.edu.ifba.comportamental;

public class TCPEstablished implements TCPState {

    @Override
    public TCPState open() {
        System.out.println("Estado Established: A conexão já está aberta.");
        return this;
    }

    @Override
    public TCPState close() {
        System.out.println("Estado Established: Fechando a conexão...");
        return new TCPClosed();
    }

	@Override
	public void send() {
        System.out.println("Estado Established: Pacote de dados enviado (SEND).");
	}

	@Override
	public void receiveAck() {
        System.out.println("Estado Established: Pacote de dados recebido e reconhecido (ACK).");
	}
}
