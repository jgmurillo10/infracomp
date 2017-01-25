package Intro.nThread;

public class T extends Thread{
	private int id;
	public T (int id){
		this.id=id;
	}
	
	public void run(){
		//puede usar id
		System.out.println(id);
	}
	
	public static void main(String[] args) {
		int nThreads=10;
		for (int i = 0; i < nThreads; i++) {
			new T(i).start();
		}
	}
}
