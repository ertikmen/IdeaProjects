package com.ertikmen.utility;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Getter

public class ConnectionProvider {

    private final String USERNAME="postgres";
    private final String PASSWORD="root";
    private final String DB_NAME="java10FutbolDb";
    private final String URL="jdbc:postgresql://localhost:5432/";
    private Connection connection;

    public boolean openConnection(){
        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Bağlantı başarılı");
            return true;
        } catch (SQLException e) {
            System.out.println("Bağlantı başarısız!!!!!!");
            return false;
        }
    }
    public void closeConnection(){
        try {
            if (!connection.isClosed()){
                connection.close();
                System.out.println("Bağlantı sonlandırıldı...");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
