package br.edu.ifba.estrutural.facade;

import java.util.List;
import java.util.logging.Logger;

public class Client {
	
	
	public static final Logger LOGGER = Logger.getLogger(Client.class.getName());

	private void runBasic() {
        String sourceCode = "int x = 10; int y = x + 5; print(y);";
		Compiler compiler1 = new Compiler();
		compiler1.compile(sourceCode);
		System.out.println("Cliente (Default): Código compilado.");
	}	


	private void runAdvanced() {
        String sourceCode = "int x = 10; int y = x + 5; print(y);";
        
        Client.LOGGER.info("Compiler: Iniciando o processo de compilação.");
        String[] tokens = (new CScanner()).run(sourceCode);
        AST ast = new BasicParser().run(tokens);
        AST optimizedAst = ProgramNodeBuilder.builder().reset().optimizer().build().run(ast);
        List<Byte> bytecode = (new JVMByteCodeStream()).generate(optimizedAst);
        Client.LOGGER.info("Codigo gerado: " + bytecode.size() + " bytes");
        Client.LOGGER.info("Compiler: Compilação concluída.");
		System.out.println("Cliente (Advanced): Código compilado.");
	}	
	
	
	
	 public static void main(String[] args) {
		 new Client().runBasic();
	 }


}
