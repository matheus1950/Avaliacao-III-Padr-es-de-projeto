package br.edu.ifba.comportamental;

public class TCPListen implements TCPState {

    @Override
    public TCPState open() {
        System.out.println("Estado Listen: Recebendo solicitação de abertura... Conexão estabelecida.");
        return new TCPEstablished();
    }

    @Override
    public TCPState close() {
        System.out.println("Estado Listen: Fechando a conexão que estava escutando.");
        return new TCPClosed();
    }

	@Override
	public void receiveAck() {
        System.out.println("Estado Listen: Ack recebido.");
	}

	@Override
	public void send() {
        System.out.println("Estado Listen: Acknowledge não é aplicável. Lançar exceção.");
	}    
}
