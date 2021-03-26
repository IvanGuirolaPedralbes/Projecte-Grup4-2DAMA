package Backend;

public abstract class Jugador{
	//Cremos los atributos de la clase
	protected String username;
	protected int punts;
	
	
	//Creem el constructor de la clase
	public Jugador(String username) {
		this.username = username;
		this.punts = 0;
	}
	
}
