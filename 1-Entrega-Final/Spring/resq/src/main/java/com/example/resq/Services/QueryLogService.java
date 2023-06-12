package com.example.resq.Services;


import com.example.resq.Models.QueryLog;
import com.example.resq.Repository.QueryLogRepository;
import com.example.resq.Repository.QueryLogRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/querylog")
public class QueryLogService {
    @Autowired
    private QueryLogRepository queryLogRepository;

    @GetMapping("/reporte")
    public ResponseEntity<List<Object[]>> obtenerReporte() {
        queryLogRepository.obtenerReporte();
        List<Object[]> datos = queryLogRepository.obtenerDatosReporte();
        queryLogRepository.dropTabla();
        return ResponseEntity.ok(datos);
    }
    @GetMapping
    public ResponseEntity<List<QueryLog>> getAllQueryLogs() {
        List<QueryLog> queryLogs = queryLogRepository.findAll();
        return ResponseEntity.ok(queryLogs);
    }

}
