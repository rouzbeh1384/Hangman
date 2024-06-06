package com.example.demo.controller;

import com.example.demo.Database.Database;
import com.example.demo.Model.gamer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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

    @FXML
    private TableColumn<?, ?> Age;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> Point;

    @FXML
    private TableColumn<?, ?> Rank;

    @FXML
    private TableColumn<?, ?> Time;

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
    public void resetData(){
        for (int i=0;i<Database.getinformation().size();i++){
            ///
        }
    }

}



