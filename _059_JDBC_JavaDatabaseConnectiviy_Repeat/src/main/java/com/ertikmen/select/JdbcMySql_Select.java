package com.ertikmen.select;

import java.sql.*;

public class JdbcMySql_Select {

    public static final String DB_URL="jdbc:mysql://localhost:3306/companydb";
    public static final String USERNAME="root";
    public static final String PASSWORD="root";

    public static final String DB_DRIVER_CLASS_NAME="com.mysql.cj.jdbc.Driver";

    public static final String QUERY_SELECT_CUSTOMERS="select * from customers";

    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            Class.forName(DB_DRIVER_CLASS_NAME);
            connection= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(QUERY_SELECT_CUSTOMERS);

            while(resultSet.next()){
                System.out.println(resultSet.getInt("customer_id")
                        +"-"+resultSet.getString("first_name")
                        +"-"+resultSet.getString("country"));
            }
        } catch (Exception e) {
            System.out.println("Hata: "+e);
        }finally {
            if (resultSet!=null) resultSet.close();
            if (statement!=null) statement.close();
            if (connection!=null) connection.close();
        }
    }


}
