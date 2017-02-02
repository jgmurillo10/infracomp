
public class Id {
	private int id;
	private int nFilas;
	public Id(int nFilas){
		id=0;
		this.nFilas=nFilas;
	}
	public synchronized int getId(){
		return id>nFilas-1?-1:id++;
	}
	public int getIdActual(){
		return id;
	}
}