package ro.javacrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_crud", connectionProps);

            String insertProdus1 = "INSERT INTO produse (nume, categorie, pret) VALUES ('Scaun', 'Mobilier', '120')";
            String insertProdus2 = "INSERT INTO produse (nume, categorie, pret) VALUES ('Masa', 'Mobilier', '250')";
            String insertProdus3 = "INSERT INTO produse (nume, categorie, pret) VALUES ('Lampa', 'Electrocasnice', '80')";
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(insertProdus1);
                stmt.executeUpdate(insertProdus2);
                stmt.executeUpdate(insertProdus3);
                System.out.println("Produs adăugat!");
            }

            String insertClient1 = "INSERT INTO clienti (nume, adresa, telefon) VALUES ('Maria Ionescu', 'Cluj', '0745123456')";
            String insertClient2 = "INSERT INTO clienti (nume, adresa, telefon) VALUES ('Andrei Popescu', 'Bucuresti', '0722334455')";
            String insertClient3 = "INSERT INTO clienti (nume, adresa, telefon) VALUES ('Ioana Matei', 'Iasi', '0755111222')";

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(insertClient1);
                stmt.executeUpdate(insertClient2);
                stmt.executeUpdate(insertClient3);
                System.out.println("Client adăugat!");
            }

            String selectProd = "SELECT * FROM produse";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectProd)) {
                System.out.println("\n--- Lista produse ---");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id")
                            + ", Nume: " + rs.getString("nume")
                            + ", Categorie: " + rs.getString("categorie")
                            + ", Pret: " + rs.getString("pret"));
                }
            }

            String selectClient = "SELECT * FROM clienti";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectClient)) {
                System.out.println("\n--- Lista clienti ---");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id")
                            + ", Nume: " + rs.getString("nume")
                            + ", Adresa: " + rs.getString("adresa")
                            + ", Telefon: " + rs.getString("telefon"));
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
