package br.ifba.ads.inf011.framework;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ApplicationTemplate<T extends Document> {
	
	private List<T> docs;
	
	public ApplicationTemplate() {
		this.docs = new LinkedList<T>();
	};
	
	public void newDocument(String name,  Class<T> documentClass) throws Exception{
		T doc = this.createDocument(name, documentClass);
		this.docs.add(doc);
		doc.open();
	};

	protected T createDocument(String name, Class<T> documentClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		java.lang.reflect.Constructor<T> constructor = documentClass.getDeclaredConstructor(String.class);
		T document = constructor.newInstance(name);
		return document;
	};
	
	public void openDocument(String name) {
		Optional<T> opDoc = this.findDocument(name);
		if(opDoc.isEmpty())
			return;
		opDoc.get().open();
	};
	
	private Optional<T> findDocument(String name) {
		return this.docs.stream()
					    .filter(doc -> doc.getName().equals(name))
					    .findFirst();
	};
	

}
