package com.example.csit228_f1_v2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RegBtn;

    @FXML
    private TextField RegName;

    @FXML
    private PasswordField RegPass;

    @FXML
    private TextField RegUser;

    @FXML
    void initialize() {
        assert RegBtn != null : "fx:id=\"RegBtn\" was not injected: check your FXML file 'register-view.fxml'.";
        assert RegName != null : "fx:id=\"RegName\" was not injected: check your FXML file 'register-view.fxml'.";
        assert RegPass != null : "fx:id=\"RegPass\" was not injected: check your FXML file 'register-view.fxml'.";
        assert RegUser != null : "fx:id=\"RegUser\" was not injected: check your FXML file 'register-view.fxml'.";

        RegBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try (Connection c = MySQLConnection.getConnection();
                     PreparedStatement st = c.prepareStatement("INSERT INTO project (name, username, password) VALUES (?, ?, ?)")) {
                    String name = RegName.getText();
                    String user = RegUser.getText();
                    String password = RegPass.getText();
                    st.setString(1, name);
                    st.setString(2, user);
                    st.setString(3, password);
                    int rowsUsed = st.executeUpdate();
                    if (rowsUsed > 0) {
                        System.out.println("We're In, we inserted this much rows: " + rowsUsed);
                        HelloApplication.stage.setScene(HelloApplication.OriginalScene);
                    } else
                        System.out.println("You missed Entirely SIR!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        });
    }



    }

