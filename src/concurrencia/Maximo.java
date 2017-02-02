
public class Maximo {

	private int nThreads;
	private int maximo;
	private int nFila;
	public synchronized boolean anotar(int n, int fila){
		System.out.println(n + ", " + fila);
		nThreads--;
		if(n>maximo) maximo=n;
		System.out.println("anotar!!!!");
		return (nThreads==-1);		
	}
	public Maximo(int nThreads, int nFila){
		this.nThreads=nThreads;
		this.nFila=nFila;
	}
	public int getMaximo(){
		return maximo;
	}
	
	
	
}