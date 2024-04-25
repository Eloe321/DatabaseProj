package crud;

import com.example.csit228_f1_v2.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement st = c.prepareStatement("DELETE FROM users WHERE name = ?")) {
            st.setString(1, "Nina");
            int rowsDel = st.executeUpdate();

            if(rowsDel > 0){
                System.out.println("WE GOT RID OFF THE FILTH! THIS MUCH FILTH: "+ rowsDel);

            }else
                System.out.println("There were none such filth detected my Lord");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

