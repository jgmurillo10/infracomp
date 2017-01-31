package concurrencia.sincronizacion;

public class Id {
	public int id;
	public Id(){
		id=0;
	}
	public synchronized int getId(){
		return id++;
	}
	public int getIdActual(){
		return id;
	}
}
