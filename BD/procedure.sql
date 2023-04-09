CREATE OR REPLACE PROCEDURE reporte()
LANGUAGE SQL
AS $$
SELECT username, 
       COUNT(*) FILTER (WHERE query_type = 'INSERT') AS insert_count,
       COUNT(*) FILTER (WHERE query_type = 'UPDATE') AS update_count,
       COUNT(*) FILTER (WHERE query_type = 'DELETE') AS delete_count,
       string_agg(query, '; ') AS queries
FROM log_queries
GROUP BY username
ORDER BY COUNT(*) DESC;
$$;
