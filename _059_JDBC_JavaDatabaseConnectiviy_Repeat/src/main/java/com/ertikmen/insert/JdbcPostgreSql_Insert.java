package com.ertikmen.insert;

import java.sql.*;

public class JdbcPostgreSql_Insert {

    static final String DB_URL="jdbc:postgresql://localhost:5432/DbOgrenciNot";
    static final String USERNAME="postgres";
    static final String PASSWORD="root";
    static final String DB_DRIVER_CLASS_NAME="org.postgresql.Driver";

    static final String QUERY_SELECT_OGRENCILER="select * from tblogrenciler";
    public static final String QUERY_INSERT_OGRENCI="insert into tblogrenciler (ograd,ogrsoyad,ogrcinsiyet,ogrkulup,ogrsehir) values\n" +
            " ('Osman','George','Erkek','Satranç','İzmir')";

    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try{

            Class.forName(DB_DRIVER_CLASS_NAME);
            connection= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            statement=connection.createStatement();
            statement.executeUpdate(QUERY_INSERT_OGRENCI);
            resultSet=statement.executeQuery(QUERY_SELECT_OGRENCILER);

            while (resultSet.next()){
                System.out.println(resultSet.getInt("ogrid")
                        +"-"+resultSet.getString("ograd")
                        +"-"+resultSet.getString("ogrsehir")
                        +"-"+resultSet.getString("ogrkulup"));
            }


        }catch (Exception e){
            System.out.println("Hata: "+e);
        }finally {
            if (resultSet!=null) resultSet.close();
            if (statement!=null) statement.close();
            if (connection!=null) connection.close();
        }
    }



}
