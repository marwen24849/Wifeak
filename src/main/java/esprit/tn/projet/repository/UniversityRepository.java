package esprit.tn.projet.repository;

import esprit.tn.projet.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {

    public Optional<University> findUniversityByNomUniversitaire(String nomUniversitaire);

}
