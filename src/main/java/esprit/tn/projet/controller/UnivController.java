package esprit.tn.projet.controller;

import esprit.tn.projet.entity.University;
import esprit.tn.projet.services.UnivService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/universitys")
@AllArgsConstructor
public class UnivController {

    private UnivService univService;

    @GetMapping("/{id}")
    public ResponseEntity<University> dofindById(@PathVariable Long id){
        return ResponseEntity.ok(univService.findUnivById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<University> dofindByName(@PathVariable String name){
        return ResponseEntity.ok(univService.findUnivByName(name));
    }

    @GetMapping
    public ResponseEntity<List<University>> doFindAll(){
        return ResponseEntity.ok(univService.findAll());
    }


    @PostMapping
    public ResponseEntity<Map<String, String>> doAdd(@RequestBody University u){
        return ResponseEntity.status(HttpStatus.CREATED).body(univService.addUniv(u));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> doUpdate(@PathVariable Long id, @RequestBody University u){
        return ResponseEntity.ok(univService.updateUniv(id, u));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> doDelete(@PathVariable Long id){
        return ResponseEntity.ok(univService.deleteByID(id));
    }


}
