DROP TABLE IF EXISTS voluntario_emergencia;

DROP TABLE IF EXISTS voluntario_habilidad;

DROP TABLE IF EXISTS ranking;

DROP TABLE IF EXISTS voluntario;

DROP TABLE IF EXISTS tarea;

DROP TABLE IF EXISTS estado;

DROP TABLE IF EXISTS emergencia_habilidad;

DROP TABLE IF EXISTS habilidad;

DROP TABLE IF EXISTS emergencia;

DROP TABLE IF EXISTS institucion;

DROP TABLE IF EXISTS queries_log;

CREATE TABLE institucion (
    id_institucion SERIAL PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE emergencia (
    id_emergencia SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    gravedad VARCHAR(255),
    fecha DATE,
    estado VARCHAR(255),
    region VARCHAR(255),
    longitud DOUBLE PRECISION,
    latitud DOUBLE PRECISION,
    geom VARCHAR(255),
    id_institucion INTEGER,
    FOREIGN KEY (id_institucion) REFERENCES institucion (id_institucion)
);

CREATE TABLE habilidad (
    id_habilidad BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE emergencia_habilidad (
    id_emergencia_habilidad SERIAL PRIMARY KEY,
    id_emergencia INTEGER,
    id_habilidad INTEGER,
    FOREIGN KEY (id_emergencia) REFERENCES emergencia (id_emergencia),
    FOREIGN KEY (id_habilidad) REFERENCES habilidad (id_habilidad)
);

CREATE TABLE estado (
    id_estado SERIAL PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE tarea (
    id_tarea SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    region VARCHAR(255),
    longitud DOUBLE PRECISION,
    latitud DOUBLE PRECISION,
    geom VARCHAR(255),
    id_estado INTEGER,
    id_emergencia INTEGER,
    FOREIGN KEY (id_estado) REFERENCES estado (id_estado),
    FOREIGN KEY (id_emergencia) REFERENCES emergencia (id_emergencia)
);

CREATE TABLE voluntario (
    id SERIAL PRIMARY KEY,
    rut VARCHAR(20),
    nombres VARCHAR(255),
    apellidos VARCHAR(255),
    fecha_nac DATE,
    disponibilidad VARCHAR(255),
    telefono VARCHAR(20),
    rol VARCHAR(255),
    contrasena VARCHAR(255),
    region VARCHAR(255),
    longitud DOUBLE PRECISION,
    latitud DOUBLE PRECISION,
    geom GEOMETRY(Point, 0)
);

CREATE TABLE voluntario_emergencia (
    id_voluntario_emergencia SERIAL PRIMARY KEY,
    id_voluntario INTEGER,
    id_emergencia INTEGER,
    FOREIGN KEY (id_voluntario) REFERENCES voluntario (id),
    FOREIGN KEY (id_emergencia) REFERENCES emergencia (id_emergencia)
);

CREATE TABLE voluntario_habilidad (
    id_voluntario_habilidad SERIAL PRIMARY KEY,
    id_voluntario INTEGER,
    id_habilidad INTEGER,
    FOREIGN KEY (id_voluntario) REFERENCES voluntario (id),
    FOREIGN KEY (id_habilidad) REFERENCES habilidad (id_habilidad)
);

CREATE TABLE ranking (
    id_ranking SERIAL PRIMARY KEY,
    id_voluntario INTEGER,
    id_tarea INTEGER,
    FOREIGN KEY (id_voluntario) REFERENCES voluntario (id),
    FOREIGN KEY (id_tarea) REFERENCES tarea (id_tarea)
);

CREATE TABLE queries_log (
	id SERIAL PRIMARY KEY,
	usuario varchar(255),
	query TEXT,
	tipo_operacion varchar(255),
	tabla varchar(255),
	tiempo TIMESTAMP
);