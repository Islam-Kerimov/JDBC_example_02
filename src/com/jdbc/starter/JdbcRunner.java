package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
//        Long flightId = 2L;
//        List<Long> result = getTicketsByFlightId(flightId);
//        System.out.println(result);

        List<Long> result = getFlightBetween(
                LocalDate.of(2020, 1, 1).atStartOfDay(),
                LocalDateTime.now());
        System.out.println(result);
    }

    private static List<Long> getFlightBetween(LocalDateTime start, LocalDateTime end) {
        String sql = """
                SELECT id 
                FROM flight 
                WHERE departure_date BETWEEN  ? AND ?
                """;

        List<Long> result = new ArrayList<>();

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            System.out.println(preparedStatement);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(start));
            System.out.println(preparedStatement);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(end));
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getObject("id", Long.class));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static List<Long> getTicketsByFlightId(Long flightId) {
        String sql = "SELECT id FROM ticket WHERE flight_id = ?";

        List<Long> result = new ArrayList<>();

        try (Connection connection = ConnectionManager.open();
             PreparedStatement prepareStatement = connection.prepareStatement(sql)) {

            prepareStatement.setLong(1, flightId);

            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getObject("id", Long.class));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
