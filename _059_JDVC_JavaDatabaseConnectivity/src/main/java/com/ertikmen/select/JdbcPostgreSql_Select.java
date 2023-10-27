package com.ertikmen.select;

import java.sql.*;

public class JdbcPostgreSql_Select {

    static final String DB_URL="jdbc:postgresql://localhost:5432/dbMusteri";
    static final String USER_NAME="postgres";
    static final String PASSWORD="root";

    static final String QUERY_SELECT_MUSTERI_ALL="select * from tblmusteri where id=1006";

    static final String DB_DRIVER_CLASS_NAME="org.postgresql.Driver";

    public static void main(String[] args) throws SQLException {

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try{
            Class.forName(DB_DRIVER_CLASS_NAME);
            connection= DriverManager.getConnection(
                    DB_URL,
                    USER_NAME,
                    PASSWORD);
            statement =connection.createStatement();
            resultSet=statement.executeQuery(QUERY_SELECT_MUSTERI_ALL);

            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+" - "+resultSet.getString("ad")+" - "+resultSet.getString("soyadi"));
            }

        }catch (Exception e){
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
