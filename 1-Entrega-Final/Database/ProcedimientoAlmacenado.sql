CREATE OR REPLACE PROCEDURE public.obtener_reporte()
LANGUAGE plpgsql
AS $$
DECLARE row record;
BEGIN
    DROP TABLE IF EXISTS temp_reporte;
    -- Crear la tabla temporal si no existe
    CREATE TABLE IF NOT EXISTS public.temp_reporte
	(
    	id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    	tipo_operacion character varying(255) COLLATE pg_catalog."default",
    	total_queries bigint,
    	usuario character varying(255) COLLATE pg_catalog."default",
    	CONSTRAINT temp_reporte_pkey PRIMARY KEY (id)
	);
        
    -- Insertar los datos en la tabla temporal
    INSERT INTO temp_reporte (tipo_operacion, usuario, total_queries)
    SELECT
        ql.tipo_operacion,
        ql.usuario,
        COUNT(*) AS total_queries
    FROM
        queries_log ql
    WHERE
        ql.tipo_operacion IN ('INSERT', 'UPDATE', 'DELETE')
    GROUP BY
        ql.tipo_operacion,
        ql.usuario
    HAVING
        COUNT(*) = (SELECT MAX(count) FROM (SELECT COUNT(*) FROM queries_log ql2 WHERE ql2.tipo_operacion = ql.tipo_operacion GROUP BY ql2.usuario) AS subquery)
    ORDER BY
        tipo_operacion;
    
    -- Mostrar los datos de la tabla temporal
    FOR row IN SELECT * FROM temp_reporte
    LOOP
        RAISE NOTICE 'Tipo de operación: %; Usuario: %; Total de queries: %', row.tipo_operacion, row.usuario, row.total_queries;
    END LOOP;
    
END;
$$;

ALTER PROCEDURE public.obtener_reporte()
OWNER TO postgres