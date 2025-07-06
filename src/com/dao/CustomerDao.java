package com.dao;

import java.sql.SQLException;

import com.connection.ConnectionFactory;
import com.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDao {
    public void insert(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (name, address, phone, cpf, rg) VALUES (?, ?, ?, ?, ?)";
    
        try (Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAdress().toString());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getCpf());
            stmt.setString(5, customer.getRg());
            stmt.executeUpdate();
        }
    }
}
