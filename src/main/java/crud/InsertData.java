package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement st = c.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)"))
        {
               String name = "Nina";
               String email = "nina@gmail.com";
               st.setString(1, name);
               st.setString(2, email);
               int rowsUsed = st.executeUpdate();
               if(rowsUsed > 0){
                   System.out.println("We're In, we inserted this much rows: " + rowsUsed);
               }else
                   System.out.println("You missed Entirely SIR!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
