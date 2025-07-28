package br.edu.ifba.inf011;

public class Client {

	
	public void iterar(Iterador it) {
		
		it.first();
		while(it.hasNext()) {
			System.out.println(it.get());
			it.next();
		}
		
	}
	
	
	public void run() {
        MyList myList = new MyList();
        myList.add("Banana");
        myList.add("Cenoura");
        myList.add("Damasco");
        myList.add("Espinafre");
        myList.add("Maçã");
        
        Iterador it = myList.createIterador();
        this.iterar(it);
	}
	
	
	public static void main(String[] args) {
		(new Client()).run();
	}

}
