package Logica;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Random;

import javax.persistence.Entity;

import Datos.PreguntasBD;

@Entity
public class PreguntaDiccionarioLogica extends Pregunta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String palabraDiccionario;
	
	
	public PreguntaDiccionarioLogica() {
		String [] preguntaDiccionario= new String[2];
		try {
			preguntaDiccionario= PreguntasBD.getPreguntaDiccionario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id_Pregunta=preguntaDiccionario[0];
		this.palabraDiccionario=preguntaDiccionario[1];
		
	}
	
	public PreguntaDiccionarioLogica(String id_Pregunta, String palabraDiccionario) {
		super(id_Pregunta);
		this.palabraDiccionario = palabraDiccionario;
	}



	public String getPalabraDiccionario() {
		return palabraDiccionario;
	}

	public void setPalabraDiccionario(String palabraDiccionario) {
		this.palabraDiccionario = palabraDiccionario;
	}
	
	public String getId_Pregunta() {
        return id_Pregunta;
    }


    public void setId_Pregunta(String id_Pregunta) {
        this.id_Pregunta = id_Pregunta;
    }
    
    
	public boolean comprobarRespuesta(char[] respuesta) {
		for(int i = 0; i<respuesta.length; i++) {
			if(Character.toLowerCase(respuesta[i]) != palabraDiccionario.toLowerCase().charAt(i))
				return false;
		}
		return true;
	}

	
	
	@Override
	void cogerPregunta() {
	
		
	}
	//Creamos los atributos de la classe
	

}
