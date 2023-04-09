package grupo1.lab1.Services;

import grupo1.lab1.Models.Ranking;
import grupo1.lab1.Repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RankingService {
    private final RankingRepository rankingRepository;
    RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }
    @GetMapping("/ranking")
    public List<Ranking> getAllRanking() {
        return rankingRepository.findAll();
    }

    @GetMapping("/ranking/{id}")
    Ranking findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return rankingRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/ranking/puntaje/{puntaje}")
    Ranking findByPuntaje(@PathVariable("puntaje") String puntaje_str){
        Integer puntaje;
        try{
            puntaje = Integer.parseInt(puntaje_str);
            return rankingRepository.findByPuntaje(puntaje);
        }catch(Exception e){
            System.out.println("Ingrese un puntaje valido");
            return null;
        }
    }

    @GetMapping("/ranking/nombre/{nombre}")
    Ranking findByNombre(@PathVariable("nombre") String nombre){
        try {
            return rankingRepository.findByNombre(nombre);
        }catch(Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @GetMapping("/ranking/voluntario/{id}")
    Ranking findByVoluntario(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return rankingRepository.findByVoluntario(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/ranking/tarea/{id}")
    Ranking findByTarea(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return rankingRepository.findByTarea(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @PostMapping("/ranking")
    @ResponseBody
    public Ranking saveRanking(@RequestBody Ranking ranking){
        return rankingRepository.save(ranking);
    }

    @DeleteMapping("/ranking/{id}")
    public void deleteRanking(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            rankingRepository.delete(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }

}
