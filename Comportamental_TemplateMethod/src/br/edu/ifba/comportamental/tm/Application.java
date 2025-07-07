package br.edu.ifba.comportamental.tm;

import java.util.ArrayList;
import java.util.List;

public abstract class Application {
    private List<Document> documents = new ArrayList<>(); // Coleção de documentos gerenciados pela aplicação

    //MétodoTemplate
    public final void openDocument(String name) throws Exception{
        System.out.println("\nIniciando processo para abrir documento: " + name);

        // Passo 1: Verificar se o documento pode ser aberto - Operação Primitiva
        if (!canOpenDocument(name)) 
        		throw new Exception("    Não foi possível abrir o documento: " + name + ". Formato inválido ou não suportado.");

        // Passo 2: Gancho para comportamento antes da abertura.
        this.aboutToOpenDocument(name); // Hook

        // Passo 3: Criar o objeto Documento específico da aplicação - Método Fábrica 
        Document doc = this.doCreateDocument(name); // Create Method (Factory Method)

        // Verifica se o documento foi realmente criado
        if (doc == null)
        	throw new Exception("    Erro: Falha ao criar o documento para: " + name);

        // Operação concreta definida na AbstractClass
        this.addDocument(doc); 
        System.out.println("    Documento '" + doc.getName() + "' adicionado à aplicação.");

        doc.doRead(); 
        System.out.println("Processo de abertura de documento concluído para: " + name);
        doc.display(); 
    }


    // Primitiva
    protected abstract boolean canOpenDocument(String name);

    //Gancho: permite a adição de um comportamento
    protected void aboutToOpenDocument(String name) {
    }

    //Método Fábrica
    protected abstract Document doCreateDocument(String name);

    // Operação Concreta da AbstractClass (utilitária)
    protected void addDocument(Document doc) {
        this.documents.add(doc);
    }

    //Operação Concreta da AbstractClass (utilitária)
    public List<Document> getDocuments() {
        return documents;
    }
}