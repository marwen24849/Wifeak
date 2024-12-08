package esprit.tn.projet.controller;

import esprit.tn.projet.entity.Foyer;
import esprit.tn.projet.entity.University;
import esprit.tn.projet.services.FoyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/foyers")
public class FoyerController {

    private FoyerService foyerService;

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> dofindById(@PathVariable Long id){
        return ResponseEntity.ok(foyerService.findFoyerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Foyer>> dofindAll(){
        return ResponseEntity.ok(foyerService.findAllFoyer());
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> doAdd(@RequestBody Foyer foyer){
        return ResponseEntity.status(HttpStatus.CREATED).body(foyerService.addFoyer(foyer));
    }
    @PostMapping("/{idU}")
    public ResponseEntity<Map<String, String>> doAddAffect(@RequestBody Foyer foyer, @PathVariable Long idU){
        return ResponseEntity.status(HttpStatus.CREATED).body(foyerService.addFoyerWithUniv(foyer, idU));
    }

    @PutMapping("/{idF}/affectUniv/{idU}")
    public ResponseEntity<Map<String, String>> doAffect(@PathVariable Long idF, @PathVariable Long idU){
        return ResponseEntity.ok(foyerService.affectUnivFoyer(idU, idF));
    }

    @PutMapping("/desAffect/{idU}")
    public ResponseEntity<University> doDesAffect(@PathVariable Long idU){
        return ResponseEntity.ok(foyerService.desaffecterFoyerAUniversite(idU));
    }

    @PutMapping("/{idF}/univName/{name}")
    public ResponseEntity<Map<String, String>> doAffect(@PathVariable Long idF, @PathVariable String name){
        return ResponseEntity.ok(foyerService.affectUnivFoyerByName(idF, name));
    }


}
