package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BorderContoroller implements Initializable {

    @FXML
    private Button back;

    @FXML
    private TableView<?> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            back.setOnAction(e->{
                try {
                    Back();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
    }

    public void Back() throws IOException {
            AnchorPane root= FXMLLoader.load(this.getClass().getResource("/com/example/demo/loginPage.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            back.getScene().getWindow().hide();
        }
    }



