package br.edu.ifba.estrutural.facade;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class JVMByteCodeStream implements ByteCodeStream{

	@Override
	public List<Byte> generate(AST optimizedAst) {
		Client.LOGGER.info("ArduinoByteCodeStream: Gerando código para Arduino a partir da AST otimizada...");
		List<Byte> bytes = new ArrayList<Byte>();
		for(String token : optimizedAst.tokens()) {
			byte[] content = token.getBytes(StandardCharsets.UTF_8);
	        int[] intArray = IntStream.range(0, content.length)
	                .map(i -> content[i] & 0xFF)
	                .toArray();
	        Arrays.stream(intArray)
            		.forEach(i -> {
	            		bytes.add((byte) ((i >> 8) & 0xFF)); // Byte mais significativo
	            		bytes.add((byte) (i & 0xFF));      // Byte menos significativo
            		});
		}	
			
		String bytecode = "BYTECODE(" + optimizedAst.getClass().getName() + ")";
		Client.LOGGER.info("DefaultBytecodeStream: Bytecode gerado: " + bytecode);
		return bytes;
	}

}