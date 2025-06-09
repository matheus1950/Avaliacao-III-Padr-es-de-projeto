package br.edu.ifba.estrutural.facade;

public interface Parser {
    public AST run(String[] tokens);
}