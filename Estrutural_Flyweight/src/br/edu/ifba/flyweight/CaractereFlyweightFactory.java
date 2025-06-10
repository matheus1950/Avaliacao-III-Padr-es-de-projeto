package br.edu.ifba.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CaractereFlyweightFactory {
	
	private static final Map<Integer, CaractereFlyweight> caracteres = new HashMap<>();

    public static CaractereFlyweight getCaractere(char valor, String fonte, int tamanho) {
    	Integer chave = gerarChave(valor, fonte, tamanho); 

        if (!caracteres.containsKey(chave)) {
            caracteres.put(chave, new CaractereConcreteFlyweight(valor, fonte, tamanho));
        }
        return caracteres.get(chave);
    }
    
    public static int poolSize() {
    	return CaractereFlyweightFactory.caracteres.size();
    }

    private static Integer gerarChave(char valor, String fonte, int tamanho) {
        return  (valor + fonte + tamanho).hashCode();
    }	

}
