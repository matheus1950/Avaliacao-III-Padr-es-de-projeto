package br.ifba.ads.inf011.framework;

import java.util.Objects;

public abstract class Document {
	
	private String name;
	
	public abstract void open();
	public abstract void close();
	
	
	public Document(String name) {
		this.name = name;
	}
	
	public void save() {
		System.out.println("Save de Document " + this.getName() + "...");
	};
	
	public void revert() {
		System.out.println("Revert de Document" + this.getName() + "...");
	}
	
	public String getName() {
		return this.name;
	};
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
	
}
