package esprit.tn.projet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversitaire;


    @Column(nullable = true, unique = true)
    private String nomUniversitaire;


    @Column(nullable = true, unique = true)
    private String adresse;




}
