package com.ertikmen.select;

import java.sql.*;

public class JdbcPostgreSql_Select {
    static final String DB_URL="jdbc:postgresql://localhost:5432/northwind";
    static final String USERNAME="postgres";
    static final String PASSWORD="root";
    static final String DB_DRIVER_CLASS_NAME="org.postgresql.Driver";

    static final String QUERY_SELECT_PRODUCTS="select * from products";

    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        int sayac=0;

        try {

            Class.forName(DB_DRIVER_CLASS_NAME);
            connection= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            statement=connection.createStatement();
 //           resultSet=statement.executeQuery(QUERY_SELECT_PRODUCTS);
            resultSet=statement.executeQuery("select * from products where unit_price>30");

 //           while (resultSet.next()){
 //               System.out.println(resultSet.getInt("product_id")+
 //                       "-"+resultSet.getString("product_name")+
 //                       "-"+resultSet.getDouble("unit_price"));
 //           }
            while(resultSet.next()){
                sayac++;
            }
            System.out.println("Sayi: "+sayac);

        }catch (Exception e){
            System.out.println("Hata: "+e);
        }finally {
            if (resultSet!=null) resultSet.close();
            if (statement!=null) statement.close();
            if (connection!=null) connection.close();
        }
    }


}
