package br.edu.ifba.estrutural.facade;

import java.util.Arrays;

public class CScanner implements Scanner {

	@Override
    public String[] run(String sourceCode) {
        Client.LOGGER.info("CScanner: Analisando o código fonte: " + sourceCode.substring(0, Math.min(sourceCode.length(), 20)) + "...");
        String[] tokens = sourceCode.split("\\s+");
        Client.LOGGER.info("CScanner: Encontrou tokens: " + Arrays.toString(Arrays.copyOfRange(tokens, 0, Math.min(tokens.length, 5))) + "...");
        return tokens;
	}
}	
    