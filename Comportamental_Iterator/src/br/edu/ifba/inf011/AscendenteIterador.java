package br.edu.ifba.inf011;

public class AscendenteIterador implements Iterador{
	
	private Integer pos;
	private MyList myList;
	
	public AscendenteIterador(MyList myList) {
		this.myList = myList;
		this.first();
	}
	
	
	@Override
	public void first() {
		this.pos = 0;
	}

	@Override
	public void next() {
		this.pos++;
	}

	@Override
	public boolean hasNext() {
		return this.myList.size() > this.pos;
	}

	@Override
	public String get() {
		return this.myList.get(this.pos);
	}
	
	
	

}
