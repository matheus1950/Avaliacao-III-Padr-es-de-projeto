package br.ifba.ads.inf011;

public class Client {
	
	public void run(PrinterSpooler prnSpooler) {
		PrinterSpooler.register(prnSpooler);
		PrinterSpooler prn = PrinterSpooler.instance();
		
		prn.print();
		prn.print();
		prn.print();
		
		PrinterSpooler prn2 = PrinterSpooler.instance();
		
		System.out.println(prn2.total());
		
	}
	
	
	
	public static void main(String[] args) {
		new Client().run(AdvancedPrinterSpooler.instance());
	}

}
