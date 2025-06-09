package br.edu.ifba.estrutural.facade;

import java.util.Arrays;

public class BasicParser implements Parser{
	
    @Override
    public AST run(String[] tokens) {
        Client.LOGGER.info("DefaultParser: Analisando a sequência de tokens: " + Arrays.toString(Arrays.copyOfRange(tokens, 0, Math.min(tokens.length, 5))) + "...");
        AST ast = new AST("Program", tokens);
        Client.LOGGER.info("DefaultParser: Gerou a Abstract Syntax Tree (AST).");
        return ast;
    }
}
