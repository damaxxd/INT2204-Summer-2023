package services;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class Connector {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/english";
    private static final String USERNAME = "vscode_user_pass1234";
    private static final String PASSWORD = "1234";
    private static Connection connection;
    private static Statement query;

    public Connector() {
    }

    public static void createConnection() {
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            query = connection.createStatement();
        } catch(Exception e) {
            System.out.println(e.getMessage() + " Cannot connect to database");
        }
    }

    public static void closeAllConnection() {
        try {
            query.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Cannot close connections");
        }
    }

    public static ResultSet executeQueryStatement(String statement) {
        try {
            return query.executeQuery(statement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void executeUpdateStatement(String statement) {
        try {
            query.executeUpdate(statement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
