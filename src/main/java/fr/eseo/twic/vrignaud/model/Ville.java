package fr.eseo.twic.vrignaud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville
        implements Serializable {

    private String nomCommune;
    private String codePostal;
    private String codeCommune;
    private String libelleAcheminement;
    private String ligne5;
    private Coordonnees coordonnees;
}
