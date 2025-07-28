package br.edu.ifba.inf011;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	
	private List<String> list;
	
	public MyList() {
		this.list = new ArrayList<String>();
	}
	
	public void add(String string) {
		this.list.add(string);
	}
	
	
	public Iterador createIterador() {
		return new RandomIterador(this);
	}

	public String get(Integer pos) {
		return this.list.get(pos);
	}
	
	public Integer size() {
		return this.list.size();
	}	
	

}
