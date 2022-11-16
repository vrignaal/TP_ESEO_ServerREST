package fr.eseo.twic.vrignaud.dao;

import fr.eseo.twic.vrignaud.config.ConsoleColor;
import fr.eseo.twic.vrignaud.config.DatabaseConfiguration;
import fr.eseo.twic.vrignaud.model.Coordonnees;
import fr.eseo.twic.vrignaud.model.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class VilleDAOImpl
        implements VilleDAO{

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public ArrayList<Ville> trouverVille(String codePostal) {
        System.out.println(ConsoleColor.PURPLE);
        System.out.println("VilleDAOImpl.trouverVille");
        System.out.println("codePostal = " + codePostal);
        ArrayList<Ville> villeArrayList = new ArrayList<Ville>();

        String query =
                "SELECT `Code_commune_INSEE`," +
                    "`Nom_commune`," +
                    "`Code_postal`," +
                    "`Libelle_acheminement`," +
                    "`Ligne_5`," +
                    "`Latitude`," +
                    "`Longitude` " +
                "FROM `ville_france`";

        if(codePostal != null) {
            query = query + " WHERE Code_postal = " + codePostal;
        }

        System.out.println("query = " + query);

        try {
            connection = DatabaseConfiguration.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                villeArrayList.add(
                        new Ville(
                                resultSet.getString("Nom_commune"),
                                resultSet.getString("Code_postal"),
                                resultSet.getString("Code_commune_INSEE"),
                                resultSet.getString("Libelle_acheminement"),
                                resultSet.getString("Ligne_5"),
                                new Coordonnees(
                                        resultSet.getString("Latitude"),
                                        resultSet.getString("Longitude")
                                )
                        ));
            }
        } catch (SQLException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.trouverVille:" + e.getMessage() + "\033[0m");

        } catch (ClassNotFoundException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.trouverVille:" + e.getMessage() + "\033[0m");

        } finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();

            } catch (SQLException e) {
                System.out.println((char)27 + "[31m" + "VilleDAOImpl.trouverVille:" + e.getMessage() + "\033[0m");

            }
        }
        System.out.println(ConsoleColor.RESET);

        return villeArrayList;
    }

    @Override
    public String ajouterVille(Ville ville) {
        System.out.println(ConsoleColor.PURPLE);
        System.out.println("VilleDAOImpl.ajouterVille");
        System.out.println("ville = " + ville);

        String query =
                "INSERT INTO `ville_france`(`Code_commune_INSEE`, " +
                        "`Nom_commune`, " +
                        "`Code_postal`, " +
                        "`Libelle_acheminement`, " +
                        "`Ligne_5`, " +
                        "`Latitude`, " +
                        "`Longitude`) " +
                "VALUES ('" + ville.getCodeCommune() + "','"
                        + ville.getNomCommune() + "','"
                        + ville.getCodePostal() + "','"
                        + ville.getLibelleAcheminement() + "','"
                        + ville.getLigne5() + "','"
                        + ville.getCoordonnees().getLatitude() + "','"
                        + ville.getCoordonnees().getLongitude() + "')";

        System.out.println("query = " + query);

        try {
            connection = DatabaseConfiguration.getConnection();
            statement = connection.createStatement();

            statement.execute(query);

            return "ok";

        } catch (SQLException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.ajouterVille:" + e.getMessage() + "\033[0m");

        } catch (ClassNotFoundException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.ajouterVille:" + e.getMessage() + "\033[0m");

        } finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();

            } catch (SQLException e) {
                System.out.println((char)27 + "[31m" + "VilleDAOImpl.ajouterVille:" + e.getMessage() + "\033[0m");

            }
        }
        System.out.println(ConsoleColor.RESET);

        return "error";
    }

    @Override
    public String modifierVille(Ville ville) {
        System.out.println(ConsoleColor.PURPLE);
        System.out.println("VilleDAOImpl.modifierVille");
        System.out.println("ville = " + ville);

        String query =
                "UPDATE `ville_france` " +
                "SET `Code_commune_INSEE`='" + ville.getCodeCommune() + "'," +
                    "`Nom_commune`='" + ville.getNomCommune() + "'," +
                    "`Code_postal`='" + ville.getCodePostal() + "'," +
                    "`Libelle_acheminement`='" + ville.getLibelleAcheminement() + "'," +
                    "`Ligne_5`='" + ville.getLigne5() + "'," +
                    "`Latitude`='" + ville.getCoordonnees().getLatitude() + "'," +
                    "`Longitude`='" + ville.getCoordonnees().getLongitude() + "' " +
                "WHERE `Code_commune_INSEE`='" + ville.getCodeCommune() + "'";

        System.out.println("query = " + query);

        try {
            connection = DatabaseConfiguration.getConnection();
            statement = connection.createStatement();

            statement.execute(query);

            return "ok";

        } catch (SQLException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.modifierVille:" + e.getMessage() + "\033[0m");
        } catch (ClassNotFoundException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.modifierVille:" + e.getMessage() + "\033[0m");
        } finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();

            } catch (SQLException e) {
                System.out.println((char)27 + "[31m" + "VilleDAOImpl.modifierVille:" + e.getMessage() + "\033[0m");
            }
        }
        System.out.println(ConsoleColor.RESET);

        return "error";
    }

    @Override
    public String supprimerVille(String codePostal) {
        System.out.println(ConsoleColor.PURPLE);
        System.out.println("VilleDAOImpl.supprimerVille");
        System.out.println("codePostal = " + codePostal);

        String query =
                "DELETE FROM `ville_france` " +
                "WHERE `Code_postal` = '" + codePostal + "'";

        System.out.println("query = " + query);

        try {
            connection = DatabaseConfiguration.getConnection();
            statement = connection.createStatement();

            statement.execute(query);

            return "ok";

        } catch (SQLException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.supprimerVille:" + e.getMessage() + "\033[0m");
        } catch (ClassNotFoundException e) {
            System.out.println((char)27 + "[31m" + "VilleDAOImpl.supprimerVille:" + e.getMessage() + "\033[0m");
        } finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();

            } catch (SQLException e) {
                System.out.println((char)27 + "[31m" + "VilleDAOImpl.supprimerVille:" + e.getMessage() + "\033[0m");
            }
        }
        System.out.println(ConsoleColor.RESET);

        return "error";
    }
}

