package br.edu.ifba.inf011;

import java.util.Random;

public class RandomIterador implements Iterador{
	
	private Boolean[] next;
	private MyList myList;
	private Integer pos;
	private Random rdn;
	private Boolean proximo;
	
	public RandomIterador(MyList myList) {
		this.rdn = new Random();
		this.myList = myList;
		this.next = new Boolean[this.myList.size()];
		for(int iCount = 0; iCount < this.next.length; iCount++)
			this.next[iCount] = Boolean.FALSE;
		this.proximo = Boolean.TRUE;
	}
	
	
	@Override
	public void first() {
		this.next();
	}
	
	private Integer nextNumber() {
		Integer nextNumber = this.rdn.nextInt(this.myList.size());
		while(!isValid(nextNumber))
			nextNumber = this.rdn.nextInt(this.myList.size());
		return nextNumber;
	}
	
	
	private boolean isValid(Integer i) {
		return !this.next[i];
	}

	@Override
	public void next() {
		this.pos = this.nextNumber();
		this.next[this.pos] = Boolean.TRUE;		
	}

	@Override
	public boolean hasNext() {
		if(!this.proximo)
			return false;
		for(int iCount = 0; iCount < this.next.length; iCount++)
			if (!this.next[iCount])
				return true;
		this.proximo = Boolean.FALSE;
		return true;
	}

	@Override
	public String get() {
		return this.myList.get(this.pos);
	}
	
	
	

}
