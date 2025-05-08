package br.ifba.ads.inf011;

public class AdvancedPrinterSpooler extends PrinterSpooler {
	
	private static AdvancedPrinterSpooler printerSpooler;
	
	public static PrinterSpooler instance() {
		if(AdvancedPrinterSpooler.printerSpooler == null)
			AdvancedPrinterSpooler.printerSpooler = new AdvancedPrinterSpooler();
		return AdvancedPrinterSpooler.printerSpooler;
	}	
	
	
	public void print() {
		super.print();
		super.print();
	}	
	
	
	

}
