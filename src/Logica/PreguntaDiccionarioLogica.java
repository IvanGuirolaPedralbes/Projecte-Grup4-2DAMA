package Logica;

import java.sql.SQLException;
import java.util.Random;

import Datos.PreguntasBD;

public class PreguntaDiccionarioLogica extends Pregunta{

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
		// Creado por Iván Guirola
		
	}
	//Creamos los atributos de la classe
	

}
