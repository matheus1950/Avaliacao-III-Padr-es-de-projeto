package br.edu.ifba.comportamental.memento;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.comportamental.memento.originator.DocumentoMemento;

public class DocumentoCaretaker {
	
    private final Map<String, DocumentoMemento> savedStates; 

    public DocumentoCaretaker() {
        this.savedStates = new HashMap<String, DocumentoMemento>();
        System.out.println("\nHistórico de Documentos: Inicializado.");
    }

    public void save(String label, DocumentoMemento memento) {
        this.savedStates.put(label, memento);
    }

    public DocumentoMemento get(String label) {
    	DocumentoMemento memento = savedStates.get(label);
        return memento;
    }

    public void listSavedVersions() {
        System.out.println("\n--- Versões Salvas ---");
        if (savedStates.isEmpty()) {
            System.out.println("Nenhuma versão salva.");
        } else {
            savedStates.keySet().forEach(System.out::println);
        }
        System.out.println("----------------------");
    }
}