package com.ertikmen.update;

import java.sql.*;

public class JdbcPostgreSql_Update {

    static final String DB_URL="jdbc:postgresql://localhost:5432/dbMusteri";
    static final String USER_NAME="postgres";
    static final String PASSWORD="root";
    static final String QUERY_SELECT_MUSTERI_ALL="select * from tblmusteri";
    static final String QUERY_UPDATE_MUSTERI_BY_ID="update tblmusteri " +
            "set ad='Mimar', soyadi='Aslan', aciklama='mimaraslan@gmail.com'" +
            " where id=998";

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

            statement.executeUpdate(QUERY_UPDATE_MUSTERI_BY_ID);

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