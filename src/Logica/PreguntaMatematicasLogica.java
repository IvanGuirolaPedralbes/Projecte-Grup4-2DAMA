package Logica;

import java.io.Serializable;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import Datos.PreguntasBD;

@Entity
public class PreguntaMatematicasLogica extends Pregunta implements Serializable{
	//Creamos els atributs de la clase
	private String operacion;
	private int respuestaCorrecta; 
	
	
	public PreguntaMatematicasLogica(String id_Pregunta, String operacion, int respuestaCorrecta) {
		super(id_Pregunta);
		this.operacion = operacion;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public PreguntaMatematicasLogica(String id_Pregunta, String operacion) {
		super(id_Pregunta);
		this.operacion = operacion;
	}



	public PreguntaMatematicasLogica() {
		
		String[] preguntaMates = new String[2];
		try {
			preguntaMates = PreguntasBD.getPreguntaMatematicas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id_Pregunta = preguntaMates[0];
		this.operacion = preguntaMates[1];
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		Object result = null;
		try {
			result = engine.eval(operacion);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.respuestaCorrecta = Integer.decode(result.toString());
	}

	public String getId_Pregunta() {
		return id_Pregunta;
	}


	public void setId_Pregunta(String id_Pregunta) {
		this.id_Pregunta = id_Pregunta;
	}
	
	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}


	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}


	public void setRespuestaCorrecta(int respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}


	@Override
	void cogerPregunta() {
		// Creado por Iván Guirola
		
	}
}
