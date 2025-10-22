package ro.javacrud.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelpers {

    public static Connection getConnection() {
        try {
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "");

            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java_crud", connectionProps);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
