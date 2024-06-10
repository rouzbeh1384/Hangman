package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginpageController implements Initializable {
    @FXML
    private Button Borderbtn;

    @FXML
    private Button LoginPageBtn;

    @FXML
    private Button regesterBtn;


    @FXML
    private AnchorPane StartPage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            LoginPageBtn.setOnAction(e-> {
                try {
                    login();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                LoginPageBtn.getScene().getWindow().hide();
            });
        Borderbtn.setOnAction(e-> {
            FXMLLoader login = new FXMLLoader(getClass().getResource("/com/example/demo/Border.fxml"));
                Stage stage=new Stage();
            Scene scene = null;
            try {
                scene = new Scene(login.load(),603  , 400);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            stage.setScene(scene);
            stage.show();

            LoginPageBtn.getScene().getWindow().hide();
        });

        regesterBtn.setOnAction(e->{
            try {
                     regester();
            }catch (IOException ex){
                ex.getStackTrace();
            }
            regesterBtn.getScene().getWindow().hide();
        });
    }


    private void login() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/Login.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }
    private void regester() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/enter2Game.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }





}
