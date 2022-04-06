package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;

        String sql = """
                UPDATE info
                SET data = 'Test'
                WHERE id  = 5
                """;
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
//            System.out.println(connection.getSchema());
//            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.executeUpdate(sql);
            System.out.println(executeResult);
        }
    }
}
