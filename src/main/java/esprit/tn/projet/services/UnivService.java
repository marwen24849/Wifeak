package esprit.tn.projet.services;


import esprit.tn.projet.entity.University;
import esprit.tn.projet.repository.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnivService {


    private final UniversityRepository universityRepository;

    public University findUnivById(Long id){
        return findById(id);
        /*Optional<University> u = universityRepository.findById(id);
        if(u.isPresent()){
            return u.get();
        }
        return null;*/
    }

    public University findUnivByName(String name){

        Optional<University> u = universityRepository.findUniversityByNomUniversitaire(name);
        if(u.isPresent()){
            return u.get();
        }
        return null;
    }

    public List<University> findAll(){
        return universityRepository.findAll();
    }

    public Map<String, String> addUniv(University university){
        universityRepository.save(university);
        return Map.of("status", "Add Done !");
    }

    public Map<String, String> updateUniv(Long id, University university){
        University u = findById(id);
        if(university.getNomUniversitaire() != null)
            u.setNomUniversitaire(university.getNomUniversitaire());
        if(university.getAdresse() != null)
            u.setAdresse(university.getAdresse());
        universityRepository.save(u);
        return Map.of("status", "Update Done !");
    }

    public Map<String, String> deleteByID(Long id){
        findById(id);
        universityRepository.deleteById(id);
        return Map.of("status", "Delete id");
    }


    private University findById(Long id){
        return universityRepository
                .findById(id)
                .orElseThrow(
                        ()->new RuntimeException("Not Found")
                );
    }
}
