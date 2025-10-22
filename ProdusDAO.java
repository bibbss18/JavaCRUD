package ro.javacrud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import ro.javacrud.pojo.Produs;

public class ProdusDAO {

    public static void insertProdus(Connection conn, Produs p) {
        try (Statement stmt = conn.createStatement()) {
            String query = "INSERT INTO produse (nume, categorie, pret) VALUES ('" 
                            + p.getNume() + "', '" + p.getCategorie() + "', '" + p.getPret() + "')";
            stmt.executeUpdate(query);
            System.out.println("Produs adăugat: " + p.getNume());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectProduse(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM produse")) {
            System.out.println("\n--- Lista produse ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Nume: " + rs.getString("nume")
                        + ", Categorie: " + rs.getString("categorie")
                        + ", Pret: " + rs.getDouble("pret"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
