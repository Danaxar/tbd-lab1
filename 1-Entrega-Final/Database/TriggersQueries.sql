CREATE OR REPLACE FUNCTION log_queries() RETURNS TRIGGER AS $$

BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO queries_log (usuario, query, tipo_operacion, tiempo, tabla) VALUES (current_user, NEW::text, 'INSERT', now(), TG_TABLE_NAME);
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO queries_log (usuario, query, tipo_operacion, tiempo, tabla) VALUES (current_user, NEW::text, 'UPDATE', now(), TG_TABLE_NAME);
    ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO queries_log (usuario, query, tipo_operacion, tiempo, tabla) VALUES (current_user, NEW::text, 'DELETE', now(), TG_TABLE_NAME);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON emergencia
FOR EACH ROW
EXECUTE FUNCTION log_queries();

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON emergencia_habilidad
FOR EACH ROW
EXECUTE FUNCTION log_queries();

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON estado
FOR EACH ROW
EXECUTE FUNCTION log_queries();

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON habilidad
FOR EACH ROW
EXECUTE FUNCTION log_queries();

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON institucion
FOR EACH ROW
EXECUTE FUNCTION log_queries();

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON tarea
FOR EACH ROW
EXECUTE FUNCTION log_queries();

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON voluntario
FOR EACH ROW
EXECUTE FUNCTION log_queries();

CREATE TRIGGER log_queries_trigger
AFTER INSERT OR UPDATE OR DELETE
ON voluntario_emergencia
FOR EACH ROW
EXECUTE FUNCTION log_queries();