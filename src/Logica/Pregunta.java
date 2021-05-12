package Logica;

import java.io.Serializable;

import javax.persistence.Id;


public abstract class Pregunta implements Serializable{
	
	@Id
	protected String id_Pregunta;
	
	public Pregunta(String id_Pregunta) {
		super();
		this.id_Pregunta = id_Pregunta;
	}



	public Pregunta() {
		super();
	}




	abstract void cogerPregunta();
	//TODO falta añadir get y seter id pregunta

}
