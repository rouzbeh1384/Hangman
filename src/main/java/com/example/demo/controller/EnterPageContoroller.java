package com.example.demo.controller;

import com.example.demo.Database.Database;
import com.example.demo.Model.gamer;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EnterPageContoroller implements Initializable {

    gamer x;
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
                    Startbtn.getScene().getWindow().hide();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    private void StartGame() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/PlayGame.fxml"));
        Parent root = loader.load();
        PlayGame playGame = loader.getController();
        playGame.gamer = x;
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    private boolean checkinformation() {
        boolean check=false;
        ArrayList<gamer>gamers=Database.getinformation();
        for (gamer gamer:gamers){
            if (gamer.getName().equals(username.getText()) && gamer.getPassWord().equals(password.getText()))
            {
            x=gamer;
          System.out.println(x.getName()+"---"+x.getPoint());
               check=true;
               break;
            }
        }


        return check;
    }
}
