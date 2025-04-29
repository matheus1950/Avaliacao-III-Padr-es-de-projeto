package br.ifba.ads.inf011.parameter.app;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.ifba.ads.inf011.framework.Document;
import br.ifba.ads.inf011.parameter.docs.AlternativeDocument;
import br.ifba.ads.inf011.parameter.docs.DefaultDocument;
import br.ifba.ads.inf011.parameter.doctypes.BasicDocumentType;
import br.ifba.ads.inf011.parameter.doctypes.DocumentType;

public class ParameterApplication {
	
	private List<Document> docs;
	
	
	public ParameterApplication() {
		this.docs = new LinkedList<Document>();
	};
	
	
	public void newDocument(String name, DocumentType tipo) {
		Document doc = this.createDocument(name, tipo);
		this.docs.add(doc);
		doc.open();
	};

	protected Document createDocument(String name, DocumentType tipo) {
		switch(tipo) {
			case BasicDocumentType.DefaultDocument : return new DefaultDocument(name);
			case BasicDocumentType.AlternativeDocument : return new AlternativeDocument(name);
		default:
			break;
		}
		return null;
	};
	
	public void openDocument(String name) {
		Optional<Document> opDoc = this.findDocument(name);
		if(opDoc.isEmpty())
			return;
		opDoc.get().open();
	};
	
	private Optional<Document> findDocument(String name) {
		return this.docs.stream()
					    .filter(doc -> doc.getName().equals(name))
					    .findFirst();
	};


}
