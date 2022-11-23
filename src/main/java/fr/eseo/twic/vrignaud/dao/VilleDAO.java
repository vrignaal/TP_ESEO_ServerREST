package fr.eseo.twic.vrignaud.dao;

import fr.eseo.twic.vrignaud.model.Ville;

import java.util.ArrayList;

public interface VilleDAO {
    public ArrayList<Ville> trouverVille(String codeCommune);
    public String ajouterVille(Ville ville);
    public String modifierVille(Ville ville);

    String supprimerVille(String codeCommune);
}
