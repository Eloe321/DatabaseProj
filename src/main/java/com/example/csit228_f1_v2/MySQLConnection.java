package com.example.csit228_f1_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/dbproject";

    public static Connection getConnection(){
        Connection c = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection(URL, "root", "");
            System.out.println("WE SUCCEEDED IN SEEDING! BABY IN CREATION!");
        }catch (ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }

        return c;
    }
}
