package com.ertikmen.select;

import java.sql.*;

public class MySqlConnection_Select {

    public static void main(String[] args) throws SQLException {

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/companydb",
                    "root",
                    "root");

            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from customers");

            while(resultSet.next()){
                System.out.println(resultSet.getInt("customer_id")+" - "+resultSet.getString("first_name")+
                        " - "+resultSet.getString("last_name")+" - "+resultSet.getString("phone")+
                        " - "+resultSet.getString("country"));
            }
        }catch(Exception e){
            System.out.println("Hata: "+e);
        }finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }

    }

}