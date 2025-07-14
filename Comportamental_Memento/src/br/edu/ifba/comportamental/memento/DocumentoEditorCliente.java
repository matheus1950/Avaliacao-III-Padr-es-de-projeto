package br.edu.ifba.comportamental.memento;

import br.edu.ifba.comportamental.memento.originator.Documento;
import br.edu.ifba.comportamental.memento.originator.DocumentoMemento;

public class DocumentoEditorCliente  {
	public void run(){
        Documento doc = new Documento();
        DocumentoCaretaker history = new DocumentoCaretaker();

        doc.displayCurrentState();


        
        doc.addText("Este é o rascunho inicial do meu documento.");
        doc.setCursorPosition(5);
        doc.displayCurrentState();
        // Salva esta versão com um rótulo
        history.save("Rascunho Inicial", doc.createMemento());


        doc.addText("\nAdicionei uma nova linha aqui.");
        doc.setCursorPosition(doc.getContent().length());
        doc.displayCurrentState();
        history.save("Versao com Nova Linha", doc.createMemento());

        doc.addText("\nEsta linha tem um erro grave.");
        doc.displayCurrentState();
        history.listSavedVersions();


        System.out.println("\n--- Restaurando Versões ---");

        System.out.println("\nApp: Restaurando 'Versao com Nova Linha'...");
        DocumentoMemento version2 = history.get("Versao com Nova Linha");
        doc.restoreMemento(version2);
        doc.displayCurrentState();

        System.out.println("\nApp: Restaurando 'Rascunho Inicial'...");
        DocumentoMemento version1 = history.get("Rascunho Inicial");
        doc.restoreMemento(version1);
        doc.displayCurrentState();

    }
	
	
	public static void main(String[] args) {
		new DocumentoEditorCliente().run();
	}
}