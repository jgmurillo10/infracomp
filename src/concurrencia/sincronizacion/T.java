package concurrencia.sincronizacion;


import concurrencia.sincronizacion.Maximo;
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
		max.anotar(maximoLocal);


	}
	public static void main(String[] args) {
		int nThreads=10;
		max=new Maximo(nThreads);
		inicializar(nThreads);
		Id id = new Id();

		for (int i = 0; i < nThreads && !max.termino(); i++) {
			System.out.println(i+": Threads");
			T t= new T(id);
			t.start();

		}
		
		System.out.println(max.getMaximo()+ ": MAXIMO");
	}
}
