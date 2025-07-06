package com.dao;

import java.sql.SQLException;

import com.connection.ConnectionFactory;
import com.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Customer> selectAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Custommer customer = new Customer(
                        rs.getString("name"),
                        rs.getString("cpf"),
                        rs.getString("phone"),
                        null,
                        rs.getString("rg")
                    );
                    customers.add(customer);
                }
        }
        return customers;
    }

    public void update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name = ?, phone = ?, address = ?, WHERE cpf = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
                stmt.setString(1, customer.getName());
                stmt.setString(2, customer.getPhone());
                stmt.setString(3, customer.getAdress().toString());
                stmt.setString(4, customer.getCpf());
                stmt.executeUpdate();
        }
    }

    public void delete(Customer customer) throws SQLException {
        String sql = "DELETE FROM customer WHERE cpf = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, customer.getCpf());
                stmt.execute();
            }
    }
}
