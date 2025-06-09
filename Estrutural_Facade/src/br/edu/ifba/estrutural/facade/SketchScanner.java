package br.edu.ifba.estrutural.facade;

import java.util.Arrays;

public class SketchScanner implements Scanner {

	@Override
    public String[] run(String sourceCode) {
        Client.LOGGER.info("SketchScanner: Analisando o código fonte: " + sourceCode.substring(0, Math.min(sourceCode.length(), 20)) + "...");
        String[] tokens = sourceCode.split("\\s+");
        Client.LOGGER.info("SketchScanner: Encontrou tokens: " + Arrays.toString(Arrays.copyOfRange(tokens, 0, Math.min(tokens.length, 5))) + "...");
        return tokens;
    }
}
