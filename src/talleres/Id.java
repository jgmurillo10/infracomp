package talleres;

public class Id {
	 public int id;
	  private int nFilas;
	  
	  public Id(int pNFilas){
	    id=0;
	    nFilas= pNFilas;
	  }
	  public synchronized int getId(){
	    if(id<nFilas)
	    {
	      return id++;
	    }
	    return -1;
	  }
	  
	  public int getIdActual(){
	    return id;
	  }

}
