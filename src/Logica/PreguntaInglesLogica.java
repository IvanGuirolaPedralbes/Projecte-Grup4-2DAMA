package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import Datos.PreguntasBD;

public class PreguntaInglesLogica extends Pregunta{
	
	private String pregunta;
	private String correcta;
	private String alt1;
	private String alt2;
	private String alt3;
	
	
	public PreguntaInglesLogica() {
		String[] preguntaIngles = new String[6];
		try {
			preguntaIngles = PreguntasBD.getPreguntaIngles();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id_Pregunta = preguntaIngles[0];
		this.pregunta = preguntaIngles[1];
		this.correcta = preguntaIngles[2];
		this.alt1 = preguntaIngles[3];
		this.alt2 = preguntaIngles[4];
		this.alt3 = preguntaIngles[5];
	}

	
	public String getId_Pregunta() {
		return id_Pregunta;
	}


	public void setId_Pregunta(String id_Pregunta) {
		this.id_Pregunta = id_Pregunta;
	}


	public String getPregunta() {
		return pregunta;
	}


	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}


	public String getCorrecta() {
		return correcta;
	}


	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	}


	public String getAlt1() {
		return alt1;
	}


	public void setAlt1(String alt1) {
		this.alt1 = alt1;
	}


	public String getAlt2() {
		return alt2;
	}


	public void setAlt2(String alt2) {
		this.alt2 = alt2;
	}


	public String getAlt3() {
		return alt3;
	}


	public void setAlt3(String alt3) {
		this.alt3 = alt3;
	}


	@Override
	public void cogerPregunta() {
		// Creado por Iván Guirola
		String[] preguntaIngles = new String[6];
	}
	
	public ArrayList<String> respuestasMezcladas() {
		ArrayList<String> list = new ArrayList<String>(4);
		list.add(correcta);
		list.add(alt1);
		list.add(alt2);
		list.add(alt3);
		Collections.shuffle(list);
		return list;
		
	}
	
	public boolean comprobarRespuesta(String respuesta) {
		if(respuesta.equals(correcta)) return true;
		else return false;
	}

}
