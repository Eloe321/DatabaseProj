package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/dbproject";
  public static final String USERNAME = "GeloKawai";
   public static final String PASSWORD = "JVSkawai";
    public static Connection getConnection(){
        Connection c = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("WE SUCCEEDED IN SEEDING! BABY IN CREATION!");
        }catch (ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }

        return c;
    }
}
