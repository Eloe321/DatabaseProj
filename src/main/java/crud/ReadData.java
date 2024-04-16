package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            Statement st = c.createStatement()){
            String quer = "SELECT * FROM users";
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
