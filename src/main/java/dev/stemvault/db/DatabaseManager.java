package dev.stemvault.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class DatabaseManager {
    private static final String DB_CREATE_TABLE = "";
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String STEMVAULT_DB =
        USER_HOME + "/.stemvault/catalog.db";

    public Connection connect() throws SQLException, IOException {
        Path path = Path.of(STEMVAULT_DB);
        Files.createDirectories(path.getParent());
        return DriverManager.getConnection("jdbc:sqlite:" + STEMVAULT_DB);
    }
    private void initialize(Connection connect) throws SQLException {
        Statement statement = connect.createStatement();

    }

}
