package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.*;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;

        String sql = "SELECT * FROM ticket";
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE)) {
//            System.out.println(connection.getSchema());
//            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.executeQuery(sql);
            while (executeResult.next()) {
                System.out.print(executeResult.getLong("id") + " ");
                System.out.print(executeResult.getString("passenger_no") + " ");
                System.out.println(executeResult.getBigDecimal("cost"));
                System.out.println("--------");
            }
        }
    }
}
