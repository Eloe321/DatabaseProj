package crud;

import com.example.csit228_f1_v2.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement st = c.prepareStatement("UPDATE users SET name = ? WHERE id = ?")) {
                String name = "Gwapo Gelo";
                int id = 1;
                st.setString(1, name);
                st.setInt(2, id);
                int rows = st.executeUpdate();
                if(rows > 0){
                    System.out.println("WE MADE A BETTER NAME!\nRows updated: "+ rows);
                }else
                    System.out.println("We found nothing sir, He never EXISTED!");

        }catch (SQLException e){

        }

    }

}
