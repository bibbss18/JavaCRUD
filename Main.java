package ro.javacrud;

import java.sql.Connection;
import java.sql.SQLException;

import ro.javacrud.helpers.DBHelpers;
import ro.javacrud.dao.*;
import ro.javacrud.pojo.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBHelpers.getConnection();

        if (conn != null) {
            ProdusDAO.insertProdus(conn, new Produs("Scaun", "Mobilier", 120));
            ProdusDAO.insertProdus(conn, new Produs("Masa", "Mobilier", 250));
            ProdusDAO.insertProdus(conn, new Produs("Lampa", "Electrocasnice", 80));
            ProdusDAO.selectProduse(conn);

            ClientDAO.insertClient(conn, new Client("Maria Ionescu", "Cluj", "0745123456"));
            ClientDAO.insertClient(conn, new Client("Andrei Popescu", "Bucuresti", "0722334455"));
            ClientDAO.insertClient(conn, new Client("Ioana Matei", "Iasi", "0755111222"));
            ClientDAO.selectClienti(conn);
        } else {
            System.out.println("Eroare");
        }
    }
}
