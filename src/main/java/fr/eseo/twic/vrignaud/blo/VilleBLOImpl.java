package fr.eseo.twic.vrignaud.blo;

import fr.eseo.twic.vrignaud.config.ConsoleColor;
import fr.eseo.twic.vrignaud.dao.VilleDAO;
import fr.eseo.twic.vrignaud.model.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VilleBLOImpl
        implements VilleBLO {

    @Autowired
    private VilleDAO villeDAO;

    @Override
    public ArrayList<Ville> getInfoVille(String codePostal) {
        System.out.println(ConsoleColor.YELLOW);
        System.out.println("VilleBLOImpl.getInfoVille");
        System.out.println("codePostal = " + codePostal + ConsoleColor.RESET);

        return villeDAO.trouverVille(codePostal);
    }

    @Override
    public String postVille(Ville ville) {
        System.out.println(ConsoleColor.YELLOW);
        System.out.println("VilleBLOImpl.postVille");
        System.out.println("ville = " + ville.toString() + ConsoleColor.RESET);

        return villeDAO.ajouterVille(ville);
    }

    @Override
    public String putVille(Ville ville) {
        System.out.println(ConsoleColor.YELLOW);
        System.out.println("VilleBLOImpl.putVille");
        System.out.println("ville = " + ville.toString() + ConsoleColor.RESET);

        return villeDAO.modifierVille(ville);
    }

    @Override
    public String deleteVille(String codePostal) {
        System.out.println(ConsoleColor.YELLOW);
        System.out.println("VilleBLOImpl.deleteVille");
        System.out.println("codePostal = " + codePostal + ConsoleColor.RESET);

        return villeDAO.supprimerVille(codePostal);
    }
}
