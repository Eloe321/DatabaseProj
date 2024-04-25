package crud;

import com.example.csit228_f1_v2.MySQLConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection c = MySQLConnection.getConnection();
        try {
            c.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
