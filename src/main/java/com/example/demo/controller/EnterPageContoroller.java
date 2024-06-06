package com.example.demo.controller;

import com.example.demo.Database.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterPageContoroller implements Initializable {

    @FXML
    private Button Startbtn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Startbtn.setOnAction(e->{
            if (checkinformation()){
                try {
                    StartGame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void StartGame() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/PlayGame.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private boolean checkinformation() {
        for (int i = 0; i< Database.getinformation().size() ;i++){
            if (Database.getinformation().get(i).getPassWord().equals(password.getText())
                    &&Database.getinformation().get(i).getName().equals(username.getText())){
                return true;
            }

        }
        return false;
    }
}
