package ru.atom.chat.Dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final Logger log = LoggerFactory.getLogger(DBConnector.class);

    private final static String URL_TEMPLATE = "jdbc:postgresql://%s:%d/%s";
    private final static String URL;
    private final static String USER = "postgres";
    private static final int PORT = 5432;
    private final static String PASSWORD = "perjxfy";
    private final static String IP = "localhost";
    private final static String DB_NAME = "chatdb";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Failed to load jdbc driver.", e);
            System.exit(-1);
        }

        URL = String.format(URL_TEMPLATE, IP, PORT, DB_NAME);
        log.info("Success. DbConnector init.");
    }

    static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    private DBConnector() { }
}
