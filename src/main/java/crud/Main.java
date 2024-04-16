package crud;

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
