package fr.eseo.twic.vrignaud.blo;

import fr.eseo.twic.vrignaud.model.Ville;

import java.util.ArrayList;

public interface VilleBLO {
    public ArrayList<Ville> getInfoVille(String codePostal);
    public String postVille(Ville ville);
    public String putVille(Ville ville);

    String deleteVille(String codePostal);
}
