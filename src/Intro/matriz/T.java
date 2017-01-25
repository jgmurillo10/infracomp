package Intro.matriz;

public class T extends Thread{
	private static int valor;
	private static int n;
	private static int [][] M;
	
	private int id;
	
	public T(int i){
		id=i;
	}
	
	private static void inicializar(){
		//inicializa valor, n y M
	}
	
	public void run(){
		int nElementos = M[id].length;
		
		for (int j = 0; j < nElementos; j++) {
			if(M[id][j]== valor){
				System.out.println(id);
			}
		}
	}
	public static void main(String[] args) {
		inicializar();
		for (int i = 0; i < n; i++) {
			new T(i).start();
		}
	}
}
