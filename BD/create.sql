DROP TABLE IF EXISTS Vol_habilidad;

DROP TABLE IF EXISTS Tarea_habilidad;

DROP TABLE IF EXISTS Ranking;

DROP TABLE IF EXISTS Tarea;

DROP TABLE IF EXISTS Estado_tarea;

DROP TABLE IF EXISTS Voluntario;

DROP TABLE IF EXISTS eme_habilidad;

DROP TABLE IF EXISTS Habilidad;

DROP TABLE IF EXISTS Emergencia;

DROP TABLE IF EXISTS Institucion;

DROP TABLE IF EXISTS log_queries;

-- Tabla de Institucion
CREATE TABLE Institucion (
    id_institucion SERIAL PRIMARY KEY,
    nombre_institucion VARCHAR(255)
);

-- Tabla de Emergencia
CREATE TABLE Emergencia (
    id_emergencia SERIAL PRIMARY KEY,
    nombre_emergencia VARCHAR(255),
    gravedad_emergencia VARCHAR(255),
    fecha_emergencia DATE,
    institucion_emergencia VARCHAR(255)
);

-- Tabla de Habilidad
CREATE TABLE Habilidad (
    id_habilidad SERIAL PRIMARY KEY,
    nombre_habilidad VARCHAR(255),
    puntaje_habilidad INT
);

-- Tabla de Eme_habilidad
CREATE TABLE Eme_habilidad (
    id_eme_habilidad SERIAL PRIMARY KEY,
    id_emergencia INT,
    id_habilidad INT,
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id_emergencia),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id_habilidad)
);

-- Tabla de Voluntario
CREATE TABLE Voluntario (
    id_voluntario SERIAL PRIMARY KEY,
    rut_voluntario VARCHAR(255),
    nombres_voluntario VARCHAR(255),
    apellidos_voluntario VARCHAR(255),
    fecha_nac_voluntario DATE,
    disponibilidad_voluntario VARCHAR(255),
    telefono_voluntario VARCHAR(12),
    contrasena_voluntario VARCHAR(255)
);

-- Tabla de Estado_tarea
CREATE TABLE Estado_tarea (
    id_estado_tarea SERIAL PRIMARY KEY,
    nombre_estado_tarea VARCHAR(255)
);

-- Tabla de Tarea
CREATE TABLE Tarea (
    id_tarea SERIAL PRIMARY KEY,
    nombre_tarea VARCHAR(255),
    -- FK
    id_emergencia INT,
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id_emergencia)
);

-- Tabla de Ranking
CREATE TABLE Ranking (
    id_ranking SERIAL PRIMARY KEY,
    nombre_ranking VARCHAR(255),
    puntaje_ranking INT,
    -- FK
    id_voluntario INT,
    id_tarea INT,
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id_voluntario),
    FOREIGN KEY (id_tarea) REFERENCES Tarea(id_tarea)
);

-- Tabla de vol_habilidad
CREATE TABLE Vol_habilidad (
    id_vol_habilidad SERIAL PRIMARY KEY,
    id_voluntario INT,
    id_habilidad INT,
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id_voluntario),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id_habilidad)
);

-- Tabla de tarea_habilidad
CREATE TABLE Tarea_habilidad (
    id_tarea_habilidad SERIAL PRIMARY KEY,
    id_tarea INT,
    id_habilidad INT,
    FOREIGN KEY (id_tarea) REFERENCES Tarea(id_tarea),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id_habilidad)
);

CREATE TABLE log_queries (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    query TEXT,
    query_type VARCHAR(10),
    query_time TIMESTAMP DEFAULT NOW()
);