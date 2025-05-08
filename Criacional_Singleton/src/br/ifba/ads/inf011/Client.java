package br.ifba.ads.inf011;

public class Client {
	
	public void run() {
		PrinterSpooler prn = PrinterSpooler.instance();
		
		prn.print();
		prn.print();
		prn.print();
		
		PrinterSpooler prn2 = PrinterSpooler.instance();
		
		System.out.println(prn2.total());
		
	}
	
	public void run2() {
		MultiPrinterSpooler prn = MultiPrinterSpooler.instance();
		
		prn.print();
		prn.print();
		prn.print();
		
		MultiPrinterSpooler prn2 = MultiPrinterSpooler.instance();
		
		prn2.print();
		prn2.print();
		
		System.out.println(prn2.total());
		
		MultiPrinterSpooler prn3 = MultiPrinterSpooler.instance();

		prn3.print();
		prn3.print();
		
		
		System.out.println(prn.total() + " " + prn.toString());
		System.out.println(prn2.total() + " " + prn2.toString());
		System.out.println(prn3.total() + " " + prn3.toString());
		

		
	}	
	
	
	public static void main(String[] args) {
		new Client().run2();
	}

}
