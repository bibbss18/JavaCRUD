package ro.javacrud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import ro.javacrud.pojo.Client;

public class ClientDAO {

    public static void insertClient(Connection conn, Client c) {
        try (Statement stmt = conn.createStatement()) {
            String query = "INSERT INTO clienti (nume, adresa, telefon) VALUES ('"
                            + c.getNume() + "', '" + c.getAdresa() + "', '" + c.getTelefon() + "')";
            stmt.executeUpdate(query);
            System.out.println("Client adăugat: " + c.getNume());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectClienti(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM clienti")) {
            System.out.println("\n--- Lista clienți ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Nume: " + rs.getString("nume")
                        + ", Adresa: " + rs.getString("adresa")
                        + ", Telefon: " + rs.getString("telefon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
