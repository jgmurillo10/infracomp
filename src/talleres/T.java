package talleres;

public class T extends Thread{
	 private static int [][] matriz;
	  private static int maximoLocal;
	  private Id id;
	  private int idNum;
	  public static Maximo max;
	  public T (Id id){
	    this.id=id;
	    this.idNum=id.getId();
	  }
	  public static void t(int nThreads, Id id){
		  for (int i = 0; i < nThreads; i++) {
				T t= new T(id);
				if(t.idNum!=-1){
					t.start();
				}
			}
	  }
	  public static void inicializar( int tam){
	    matriz = new int[tam][tam];
	    maximoLocal=-1;
	    int k=0;
	    for (int i = 0; i < matriz.length; i++) {
	      for (int j = 0; j < matriz.length; j++) {
	        matriz[i][j]=k;
	        k++;
	      }
	    }
//	        print(matriz);
	    max.anotar(maximoLocal);
	  }
	  public static void print(int[][] mat){
	    for (int i = 0; i < mat.length; i++) {
	      for (int j = 0; j < mat.length; j++) {
	        System.out.println(mat[i][j]);
	      }
	    }
	  }
	  @Override
	  public void run() {
	    for (int i = 0; i < matriz.length; i++) {
	      int iActual=idNum;
	      System.out.println(iActual+" iActual "+ i+": ite");
	      if(maximoLocal<matriz[iActual][i]){
	        maximoLocal=matriz[iActual][i];
	      }
	    }
	    
	    if(max.anotar(maximoLocal))
	    {
	      System.out.println(max.getMaximo() + ": MAXIMO");
	    }
	  }
	  public static void main(String[] args) {
	    int nThreads=10;
	    int nFilas =30;
	    max=new Maximo(nFilas);
	    inicializar(nFilas);
	    Id id = new Id(matriz.length);
	    if(nFilas<=nThreads){
	   	    for (int i = 0; i < nFilas; i++) {
	   	      T t= new T(id);
	   	      if(t.idNum !=-1)
	   	      {
	   	        t.start();
	   	      }
	   	    }
	    }
	    else{
	    	//hacer lo otro
	    	int filasRestantes=nFilas;
	    	while(filasRestantes>nThreads){
	    		t(nThreads, id);
	    		filasRestantes-=nThreads;
	    	}
	    	t(nThreads, id);
//	    	for (int i = 0; i < nThreads; i++) {
//				T t= new T(id);
//				if(t.idNum!=-1){
//					t.start();
//				}
//			}
//	    	for(int i=0; i<nFilas-nThreads;i++){
//	    		T t= new T(id);
//				if(t.idNum!=-1){
//					t.start();
//				}
//	    	}
	    }
	 
	  }
}
