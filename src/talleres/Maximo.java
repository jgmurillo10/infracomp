package talleres;

public class Maximo {
	  private int nFilas;
	  private int maximo;
	  
	  public synchronized boolean anotar(int n){
//	    System.out.println("NThreads "+ nThreads);
	    nFilas--;
	    if(n>maximo) maximo=n;
	    return (nFilas==-1);    
	  }
	  public boolean termino(){
	    return nFilas==0;
	  }
	  public Maximo(int nThreads){
//	    System.out.println(nThreads);
	    this.nFilas=nThreads;
	  }

	  public int getMaximo(){
	    return maximo;
	  }
	  
	
}
