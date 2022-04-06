package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;

public class BlobRunner {
    public static void main(String[] args) throws SQLException, IOException {
        // blob - bytea in Postgres
//        saveImage();
        getImage();
        // clob - TEXT in Postgres
    }

    private static void getImage() throws SQLException, IOException {
        String sql = """
                SELECT image FROM aircraft WHERE id = ?
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, 1);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                byte[] image = resultSet.getBytes("image");
                Files.write(Path.of("resources", "boing777_new.jpg"), image, StandardOpenOption.CREATE);
            }
        }
    }

    private static void saveImage() throws SQLException, IOException {

        String sql = """
                UPDATE aircraft
                SET image = ?
                WHERE id = 1
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setBytes(1, Files.readAllBytes(Path.of("resources", "boing777.jpg")));
            preparedStatement.executeUpdate();
        }
    }

//    private static void saveImage() throws SQLException, IOException {
//
//        String sql = """
//                UPDATE aircraft
//                SET image = ?
//                WHERE id = 1
//                """;
//
//        try (Connection connection = ConnectionManager.open();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            connection.setAutoCommit(false);
//
//            Blob blob = connection.createBlob();
//            blob.setBytes(1, Files.readAllBytes(Path.of("resources", "boing777.jpg")));
//
//            preparedStatement.setBlob(1, blob);
//            preparedStatement.executeUpdate();
//
//            connection.commit();
//        }
//    }
}
