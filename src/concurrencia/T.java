public class T extends Thread{

	private static int [][] matriz;
	private static int maximoLocal;
	private static Id id;
	public static Maximo max;
	public T (Id id){
		this.id=id;
	}
	public T (){
		
	}
	public void setId(Id id){
		this.id=id;
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
//				print(matriz);
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
		int iActual=id.getId();
		if(iActual!=-1)
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(iActual+" iActual "+ i+": ite");
			if(maximoLocal<matriz[iActual][i]){
				maximoLocal=matriz[iActual][i];

			}
		}
		System.out.println("hola");
		if(max.anotar(maximoLocal, iActual)){
			System.out.println(max.getMaximo()+ ": MAXIMO");
		}
		System.out.println("chao");


	}
	public static void main(String[] args) {
		int nThreads=10;
		int nFilas=3;
		T[] threads = new T[nThreads];
		max=new Maximo(nThreads, nFilas);
		inicializar(nFilas);
		Id id = new Id(matriz.length); 
		if(nThreads>nFilas){
			for (int i = 0; i < nFilas; i++) {
				threads[i]=new T(id); 
			}
		}
		else{
			for (int i = 0; i < nThreads; i++) {
				threads[i]=new T(id); 
			}
		}
		
		for (int i = 0; i < nFilas; i++) {
				threads[i].start();
		}
		
		
	}
}