package esprit.tn.projet.services;

import esprit.tn.projet.entity.Foyer;
import esprit.tn.projet.entity.University;
import esprit.tn.projet.repository.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
@AllArgsConstructor
public class FoyerService {
    private FoyerRepository foyerRepository;
    private UnivService univService;



    public Map<String, String> affectUnivFoyerByName(Long id ,String name){

        University u= univService.findUnivByName(name);
        Foyer f = findFoyerById(id);
        f.setUniversity(u);
        foyerRepository.save(f);
        return Map.of("status", "Done !");
    }

    public Foyer findFoyerById(Long id){
        return foyerRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
    public List<Foyer> findAllFoyer(){
        return foyerRepository.findAll();
    }
    public Map<String,String> addFoyer(Foyer f ){
        foyerRepository.save(f);
        return Map.of("status", "add Foyer !");
    }

    public Map<String,String> addFoyerWithUniv(Foyer f , Long idU){
        University u = univService.findUnivById(idU);
        f.setUniversity(u);
        foyerRepository.save(f);
        return Map.of("status", "add Foyer !");
    }

    public Map<String, String> affectUnivFoyer(Long idU, Long idF){
        University u = univService.findUnivById(idU);
        Foyer f = findFoyerById(idF);
        f.setUniversity(u);
        foyerRepository.save(f);
        return Map.of("status", "Done !");
    }


    public University desaffecterFoyerAUniversite (Long idUniversite){

        List<Foyer> foyers = foyerRepository.findAll();
        for(Foyer foyer : foyers){
            if(foyer.getUniversity() != null){
                if (foyer.getUniversity().getIdUniversitaire() == idUniversite){
                    University u = foyer.getUniversity();
                    foyer.setUniversity(null);
                    foyerRepository.save(foyer);
                    return u;
                }
            }
        }
        return null;

    }


}
