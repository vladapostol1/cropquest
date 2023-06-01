package main.java.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class Database {

    public static void createCustomTables() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/tiobe.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS your_table_name (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    difficulty INTEGER,\n"
                + "    map_data TEXT\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void uploadMap(String filePath, int difficulty) {
        String url = "jdbc:sqlite:C://sqlite/db/tiobe.db";
        String sql = "INSERT INTO your_table_name (difficulty, map_data) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Read the map data from the file
            String mapData = readFile(filePath);

            // Set the parameters for the SQL statement
            pstmt.setInt(1, difficulty);
            pstmt.setString(2, mapData);

            // Execute the SQL statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line);
                contentBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static void retrieveMapsAndCreateFiles() {
        String url = "jdbc:sqlite:C://sqlite/db/tiobe.db";
        String sql = "SELECT difficulty, map_data FROM your_table_name";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int difficulty = rs.getInt("difficulty");
                String mapData = rs.getString("map_data");

                createMapFile(difficulty, mapData);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createMapFile(int difficulty, String mapData) {
        String fileName = "map_" + difficulty + ".txt";
        String folderPath = "resources/maps/";

        try {
            Files.createDirectories(Paths.get(folderPath));
            FileWriter writer = new FileWriter(folderPath + fileName);
            writer.write(mapData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void emptyTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/tiobe.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // SQL statement to delete all rows from the table
            String sql = "DELETE FROM your_table_name";

            // Execute the DELETE statement
            stmt.executeUpdate(sql);

            System.out.println("Table emptied successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
