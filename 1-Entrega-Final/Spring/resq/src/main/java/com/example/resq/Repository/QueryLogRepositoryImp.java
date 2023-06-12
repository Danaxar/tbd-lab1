package com.example.resq.Repository;

import com.example.resq.Models.QueryLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class QueryLogRepositoryImp implements QueryLogRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<QueryLog> findAll(){
        String query = "SELECT * FROM query_log";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query)
                    .executeAndFetch(QueryLog.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public void obtenerReporte() {
        String query = "CALL obtener_reporte()";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public List<Object[]> obtenerDatosReporte() {
        String query = "SELECT CAST(usuario AS VARCHAR), tipo_operacion, total_queries FROM temp_reporte";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetchTable()
                    .asList()
                    .stream()
                    .map(row -> row.values().toArray())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public void dropTabla() {
        String query = "DROP TABLE temp_reporte";
        try (Connection conn = sql2o.open()) {
            Query sql2oQuery = conn.createQuery(query);
            sql2oQuery.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
