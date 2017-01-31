package concurrencia.sincronizacion;

public class Maximo {

	private int nThreads;
	private int maximo;
	public synchronized boolean anotar(int n){
		nThreads--;
		if(n>maximo) maximo=n;
		return (nThreads==0);		
	}
	
	
	
}
