package com.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection established successfully!");
            } else {
                System.out.println("Failed to establish connection");
            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
