package br.edu.ifba.comportamental.observer;

public class DemoObserver {
	
    public void run() {
        System.out.println("Iniciando a simulação do padrão Observer.");
        System.out.println("====================================================");

        PlanilhaDados dados = new PlanilhaDados();

        Observer graficoBarras = new GraficoBarras("Gráfico de Barras");
        Observer graficoPizza = new GraficoPizza("Gráfico de Pizza");
        Observer tabelaSimples = new Tabela("Visualização de Tabela");

        dados.attach(graficoBarras);
        dados.attach(graficoPizza);
        dados.attach(tabelaSimples);

        dados.setValor("A1", 10);

        System.out.println("\n>>> Removendo o 'Gráfico de Pizza' da lista de observadores.");
        dados.detach(graficoPizza);

        dados.setValor("B2", 5);
        
        System.out.println("\n====================================================");
        System.out.println("Simulação finalizada.");
    }
    
    public static void main(String[] args) {
		new DemoObserver().run();
	}

}
