package fr.eseo.twic.vrignaud.controller;

import fr.eseo.twic.vrignaud.blo.VilleBLO;
import fr.eseo.twic.vrignaud.config.ConsoleColor;
import fr.eseo.twic.vrignaud.model.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VilleController {

    @Autowired
    VilleBLO villeBLOService;

    // GET
    @RequestMapping(value = "/rechercherVille", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Ville> getVille(@RequestParam(required = false, value = "codeCommune") String codeCommune) {
        System.out.println(ConsoleColor.BLUE);
        System.out.println("VilleController.getVille");
        System.out.println("codePostal = " + codeCommune + ConsoleColor.RESET);

        return villeBLOService.getInfoVille(codeCommune);
    }

    // POST
    @CrossOrigin
    @RequestMapping(value = "/ajouterVille", method = RequestMethod.POST)
    @ResponseBody
    public String postVille(@RequestBody Ville ville) {
        System.out.println(ConsoleColor.BLUE);
        System.out.println("VilleController.postVille");
        System.out.println("ville = " + ville.toString() + ConsoleColor.RESET);

        return villeBLOService.postVille(ville);
    }

    // PUT
    @CrossOrigin
    @RequestMapping(value = "/modifierVille", method = RequestMethod.PUT)
    @ResponseBody
    public String putVille(@RequestBody Ville ville) {
        System.out.println(ConsoleColor.BLUE);
        System.out.println("VilleController.putVille");
        System.out.println("ville = " + ville.toString() + ConsoleColor.RESET);

        return villeBLOService.putVille(ville);
    }

    // DELETE
    @CrossOrigin
    @RequestMapping(value = "/supprimerVille", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteVille(@RequestParam(required = false, value = "codeCommune") String codeCommune) {
        System.out.println(ConsoleColor.BLUE);
        System.out.println("VilleController.deleteVille");
        System.out.println("codeCommune = " + codeCommune + ConsoleColor.RESET);

        return villeBLOService.deleteVille(codeCommune);
    }
}
