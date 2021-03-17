DROP DATABASE IF EXISTS saberyganar;
CREATE DATABASE saberyganar;
USE saberyganar;

CREATE TABLE JUGADOR (
	username VARCHAR(20) PRIMARY KEY
);

CREATE TABLE PARTIDAS (
	id_Partida INT AUTO_INCREMENT PRIMARY KEY,
	fecha DATE NOT NULL
);

CREATE TABLE RONDA (
	id_Partida INT,
    id_Ronda INT,
    PRIMARY KEY (id_Partida, id_Ronda),
    FOREIGN KEY (id_Partida) REFERENCES PARTIDAS (id_Partida) 
     ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE PREGUNTAS (
	id_Pregunta VARCHAR(50) PRIMARY KEY
);
CREATE TABLE JUGADA (
    id_Partida INT,
    id_Ronda INT,
	username VARCHAR(30),
    id_Pregunta VARCHAR(50),
    puntos TINYINT,
    PRIMARY KEY(id_Partida,id_Ronda,username),
    FOREIGN KEY (id_Pregunta) REFERENCES PREGUNTAS (id_Pregunta) 
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_Partida, id_Ronda) REFERENCES RONDA (id_Partida, id_Ronda) 
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (username) REFERENCES JUGADOR (username) 
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE DICCIONARIO (
    id_Pregunta VARCHAR(50) PRIMARY KEY,
    palabra VARCHAR(50),
    FOREIGN KEY(id_Pregunta) REFERENCES PREGUNTAS (id_Pregunta) 
    ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE MATEMATICAS (
    id_pregunta VARCHAR(50) PRIMARY KEY,
    operacion VARCHAR(50),
    FOREIGN KEY(id_Pregunta) REFERENCES PREGUNTAS (id_Pregunta) 
    ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE INGLES (
	id_Pregunta VARCHAR(50) PRIMARY KEY,
    pregunta TEXT,
    respuesta_correcta VARCHAR(255),
    adicional1 VARCHAR(255),
    adicional2 VARCHAR(255),
    adicional3 VARCHAR(255),
    FOREIGN KEY(id_Pregunta) REFERENCES PREGUNTAS (id_Pregunta) 
    ON DELETE CASCADE ON UPDATE CASCADE
);
    
    
    

    