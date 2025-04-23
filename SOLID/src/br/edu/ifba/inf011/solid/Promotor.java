package br.edu.ifba.inf011.solid;

public class Promotor{
	
	public void promover(Promovivel funcionario) throws DomainException {
		Cargo cargo = funcionario.getCargo();
		Cargo novoCargo = cargo.next();
		funcionario.setCargo(novoCargo);
	}
	

}
