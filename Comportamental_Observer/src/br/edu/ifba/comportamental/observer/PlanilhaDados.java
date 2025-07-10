package br.edu.ifba.comportamental.observer;

import java.util.ArrayList;
import java.util.List;

public class PlanilhaDados implements Subject {
	
    private List<Observer> observers;
    private String nomeCelula;
    private int valor;
    
    
    public PlanilhaDados() {
        this.observers = new ArrayList<Observer>();
    }
    
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(nomeCelula, valor);
    }

    public void setValor(String nomeCelula, int valor) {
        this.nomeCelula = nomeCelula;
        this.valor = valor;
        this.notifyObservers();
    }
}
