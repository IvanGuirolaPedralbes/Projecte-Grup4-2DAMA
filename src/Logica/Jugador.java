package Logica;

public abstract class Jugador{
	//Cremos los atributos de la clase
	protected String username;
	protected int puntuacion;
	
	
	//Creem el constructor de la clase
	public Jugador(String username) {
		this.username = username;
		this.puntuacion = 0;
	}
	
	public void sumarPunto() {
		puntuacion++;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	};
	
	
	
}
