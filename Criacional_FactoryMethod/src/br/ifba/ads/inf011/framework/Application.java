package br.ifba.ads.inf011.framework;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class Application {
	
	
	private List<Document> docs;
	
	
	public Application() {
		this.docs = new LinkedList<Document>();
	};
	
	
	public void newDocument(String name) {
		Document doc = this.createDocument(name);
		this.docs.add(doc);
		doc.open();
	};

	protected abstract Document createDocument(String name);
	
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
