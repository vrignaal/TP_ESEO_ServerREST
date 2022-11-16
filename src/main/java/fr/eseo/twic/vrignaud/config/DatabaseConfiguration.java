package fr.eseo.twic.vrignaud.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private final static String BDD_URL = "jdbc:mysql://localhost:3306/twic_ville_france";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
    }
}
