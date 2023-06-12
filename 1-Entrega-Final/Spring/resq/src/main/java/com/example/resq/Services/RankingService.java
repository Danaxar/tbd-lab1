package com.example.resq.Services;

import com.example.resq.Models.Ranking;
import com.example.resq.Repository.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @GetMapping
    public List<Ranking> getAllRankings() {
        return rankingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ranking findById(@PathVariable("id") String id_str) {
        Integer id;
        try {
            id = Integer.parseInt(id_str);
            return rankingRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Ingrese un id válido");
            return null;
        }
    }

    @GetMapping("/voluntario/{id}")
    public List<Ranking> findByVoluntario(@PathVariable("id") String id_str) {
        Integer id;
        try {
            id = Integer.parseInt(id_str);
            return rankingRepository.findByVoluntario(id);
        } catch (Exception e) {
            System.out.println("Ingrese un id válido");
            return null;
        }
    }

    @GetMapping("/tarea/{id}")
    public List<Ranking> findByTarea(@PathVariable("id") String id_str) {
        Integer id;
        try {
            id = Integer.parseInt(id_str);
            return rankingRepository.findByTarea(id);
        } catch (Exception e) {
            System.out.println("Ingrese un id válido");
            return null;
        }
    }

    @PostMapping
    public Ranking saveRanking(@RequestBody Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    @PutMapping
    public Ranking updateRanking(@RequestBody Ranking ranking) {
        return rankingRepository.update(ranking);
    }

    @DeleteMapping("/{id}")
    public void deleteRanking(@PathVariable("id") String id_str) {
        Integer id;
        try {
            id = Integer.parseInt(id_str);
            if (rankingRepository.delete(id)) {
                System.out.println("Fila eliminada con éxito");
            } else {
                System.out.println("La fila no fue eliminada");
            }
        } catch (Exception e) {
            System.out.println("Ingrese un id válido");
        }
    }
}
