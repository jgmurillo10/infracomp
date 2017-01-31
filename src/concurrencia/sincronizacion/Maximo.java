package concurrencia.sincronizacion;

public class Maximo {

	private int nThreads;
	private int maximo;
	public synchronized boolean anotar(int n){
//		System.out.println("NThreads "+ nThreads);
		nThreads--;
		if(n>maximo) maximo=n;
		return (nThreads==0);		
	}
	public boolean termino(){
		return nThreads==0;
	}
	public Maximo(int nThreads){
//		System.out.println(nThreads);
		this.nThreads=nThreads;
	}
	public int getMaximo(){
		return maximo;
	}
	
	
	
}
