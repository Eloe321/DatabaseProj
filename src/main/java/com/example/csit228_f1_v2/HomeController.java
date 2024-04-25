package com.example.csit228_f1_v2;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HomeController {

    @FXML
    private ScrollPane toDisplay;
    @FXML
    private Button Create;

    @FXML
    void initialize() {
        try(Connection c = MySQLConnection.getConnection();
            Statement st = c.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS museum (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(256) NOT NULL," +
                    "URL VARCHAR(256) NOT NULL," +
                    "description VARCHAR(256) NOT NULL)";

            st.execute(query);
            System.out.println("Museum thy Placed!");
        }catch (SQLException e){
            e.printStackTrace();
        }


        try(Connection c = MySQLConnection.getConnection();
            Statement st = c.createStatement()){
            String quer = "SELECT * FROM museum";
            ResultSet q = st.executeQuery(quer);
            while(q.next()){

                VBox museumBox = new VBox();
                Label museumNameLabel = new Label(q.getString("name"));
                Label museumDescriptionLabel = new Label(q.getString("description"));
                museumBox.getChildren().addAll(museumNameLabel, museumDescriptionLabel);

                ImageView museumImage = new ImageView(new Image(q.getString("URL")));
                museumImage.setFitWidth(200);
                museumImage.setFitHeight(200);
                museumBox.getChildren().add(museumImage);
                Pane contentPane = (Pane) toDisplay.getContent(); // Assuming content is a Pane
                contentPane.getChildren().add(museumBox);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void OpenModal() throws IOException {
        ModalController c = new ModalController();
        System.out.println("Opening Modal!");
        c.showModal();
    }
}
