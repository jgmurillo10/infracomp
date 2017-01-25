package Intro;

public class T extends Thread{

	public void run(){
		System.out.println("Running!");
	}
	public static void main(String[] args) {
		T t= new T();
		t.start();
	}
}
