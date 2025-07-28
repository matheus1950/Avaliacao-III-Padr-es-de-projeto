package br.edu.ifba.inf011;

public class DescendenteIterador implements Iterador{
	
	private Integer pos;
	private MyList myList;
	
	public DescendenteIterador(MyList myList) {
		this.myList = myList;
		this.first();
	}
	
	
	@Override
	public void first() {
		this.pos = this.myList.size() - 1;
	}

	@Override
	public void next() {
		this.pos--;
	}

	@Override
	public boolean hasNext() {
		return this.pos >= 0;
	}

	@Override
	public String get() {
		return this.myList.get(this.pos);
	}
	
	
	

}
