-- Trigger para la tabla Institucion
CREATE OR REPLACE FUNCTION log_institucion() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Institucion', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_institucion
AFTER INSERT OR UPDATE OR DELETE
ON Institucion
FOR EACH ROW
EXECUTE FUNCTION log_institucion();

-- Trigger para la tabla Emergencia
CREATE OR REPLACE FUNCTION log_emergencia() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Emergencia', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_emergencia
AFTER INSERT OR UPDATE OR DELETE
ON Emergencia
FOR EACH ROW
EXECUTE FUNCTION log_emergencia();

-- Trigger para la tabla Habilidad
CREATE OR REPLACE FUNCTION log_habilidad() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Habilidad', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_habilidad
AFTER INSERT OR UPDATE OR DELETE
ON Habilidad
FOR EACH ROW
EXECUTE FUNCTION log_habilidad();

-- Trigger para la tabla Eme_habilidad
CREATE OR REPLACE FUNCTION log_eme_habilidad() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Eme_habilidad', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_eme_habilidad
AFTER INSERT OR UPDATE OR DELETE
ON Eme_habilidad
FOR EACH ROW
EXECUTE FUNCTION log_eme_habilidad();

-- Trigger para la tabla Voluntario
CREATE OR REPLACE FUNCTION log_voluntario() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Voluntario', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_voluntario
AFTER INSERT OR UPDATE OR DELETE
ON Voluntario
FOR EACH ROW
EXECUTE FUNCTION log_voluntario();

-- Trigger para la tabla Estado_tarea
CREATE OR REPLACE FUNCTION log_estado_tarea() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Estado_tarea', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_estado_tarea
AFTER INSERT OR UPDATE OR DELETE
ON Estado_tarea
FOR EACH ROW
EXECUTE FUNCTION log_estado_tarea();

-- Trigger para la tabla Tarea
CREATE OR REPLACE FUNCTION log_tarea() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Tarea', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_tarea
AFTER INSERT OR UPDATE OR DELETE
ON Tarea
FOR EACH ROW
EXECUTE FUNCTION log_tarea();

-- Trigger para la tabla Ranking
CREATE OR REPLACE FUNCTION log_ranking() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Ranking', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_ranking
AFTER INSERT OR UPDATE OR DELETE
ON Ranking
FOR EACH ROW
EXECUTE FUNCTION log_ranking();

-- Trigger para la tabla Vol_habilidad
CREATE OR REPLACE FUNCTION log_vol_habilidad() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Vol_habilidad', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_vol_habilidad
AFTER INSERT OR UPDATE OR DELETE
ON Vol_habilidad
FOR EACH ROW
EXECUTE FUNCTION log_vol_habilidad();

-- Trigger para la tabla Tarea_habilidad
CREATE OR REPLACE FUNCTION log_tarea_habilidad() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_queries (username, query, query_type) VALUES (CURRENT_USER, TG_OP || ' on Tarea_habilidad', TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_tarea_habilidad
AFTER INSERT OR UPDATE OR DELETE
ON Tarea_habilidad
FOR EACH ROW
EXECUTE FUNCTION log_tarea_habilidad();
