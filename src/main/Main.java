package main;

import connection.MYSQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = MYSQLConnection.getConnection()) {
            System.out.println("tc");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
