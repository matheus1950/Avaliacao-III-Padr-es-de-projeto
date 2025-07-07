package br.edu.ifba.comportamental.tm;

public class SpreadsheetDocument extends Document {
    
	public SpreadsheetDocument(String name) {
        super(name);
    }

    @Override
    public void doRead() {
        System.out.println("    Operação Primitiva: Lendo dados de planilha para o documento '" + name + "'...");
        // Lógica específica para ler um documento de planilha
    }
}