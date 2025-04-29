package br.ifba.ads.inf011.parameter.app;

import br.ifba.ads.inf011.framework.Document;
import br.ifba.ads.inf011.parameter.docs.ExtendedDocument;
import br.ifba.ads.inf011.parameter.doctypes.DocumentType;
import br.ifba.ads.inf011.parameter.doctypes.ExtendedDocumentType;

public class ExtendedParameterApplication extends ParameterApplication{
	
	protected Document createDocument(String name, DocumentType tipo) {
		switch(tipo) {
			case ExtendedDocumentType.ParticularDocument : return new ExtendedDocument(name);
		default:
			return super.createDocument(name, tipo);
		}
	};	

}
