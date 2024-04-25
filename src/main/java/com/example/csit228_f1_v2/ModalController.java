package com.example.csit228_f1_v2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.csit228_f1_v2.HelloApplication.stage;

public class ModalController implements Initializable {
    @FXML
    private AnchorPane modalPane;
    private double initialX, initialY;



    public void showModal() throws IOException {
        System.out.println("The modal Pane: " + modalPane);
        if (modalPane == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modal.fxml"));
            loader.setController(this);
            modalPane = loader.load();

        }

        StackPane modalContainer = new StackPane();
        modalContainer.getChildren().add(modalPane);

        // Add the modal container to the scene of the main application window
        stage.getScene().getRoot().getChildrenUnmodifiable().add(modalContainer);

    }

    @FXML
    public void handleClose() {
        modalPane.getParent().getChildrenUnmodifiable().remove(modalPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modalPane.setOnMousePressed(event -> {
            initialX = event.getSceneX();
            initialY = event.getSceneY();
        });

        modalPane.setOnMouseDragged(event -> {
            modalPane.setLayoutX(modalPane.getLayoutX() + event.getSceneX() - initialX);
            modalPane.setLayoutY(modalPane.getLayoutY() + event.getSceneY() - initialY);
        });
    }
}
