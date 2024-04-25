package com.example.csit228_f1_v2;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDfunctions {

    public void Createtbl(String tableName){
        try(Connection c = MySQLConnection.getConnection();
            Statement st = c.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS "+tableName+" (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(256) NOT NULL," +
                    "username VARCHAR(256) NOT NULL," +
                    "password VARCHAR(256) NOT NULL)";

            st.execute(query);
            System.out.println("Table thy Placed!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void SelectAll(){
        try(Connection c = MySQLConnection.getConnection();
            Statement st = c.createStatement()){
            String quer = "SELECT * FROM project";
            ResultSet q = st.executeQuery(quer);
            while(q.next()){
                int id = q.getInt(1);
                String name = q.getString("name");
                String email = q.getString("email");
                System.out.println("ID: "+ id + "\nName: "+name+"\nEmail: "+ email+ "\n");

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
