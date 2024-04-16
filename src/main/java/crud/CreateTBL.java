package crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTBL {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            Statement st = c.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS Project (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50) NOT NULL," +
                    "username VARCHAR(100) NOT NULL," +
                    "password VARCHAR(15) NOT NULL)";

            st.execute(query);
            System.out.println("Table thy Placed!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
