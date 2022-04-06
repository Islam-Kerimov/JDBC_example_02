package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.*;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;

        String sql = "INSERT INTO info(data) VALUES ('fsdfsdfs')";
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE)) {
//            System.out.println(connection.getSchema());
//            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int generatedKeysInt = generatedKeys.getInt("id");
                System.out.println(generatedKeysInt);
            }
        }
    }
}
