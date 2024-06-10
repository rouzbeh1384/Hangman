package com.example.demo.controller;

import com.example.demo.Database.Database;
import com.example.demo.Model.gamer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BorderContoroller implements Initializable {



    @FXML
    private TableColumn<gamer, Integer> Age;

    @FXML
    private TableColumn<gamer,  String> Email;

    @FXML
    private TableColumn<gamer,  String> Ground;

    @FXML
    private TableColumn<gamer,  Integer> Rank;

    @FXML
    private Button back;

    @FXML
    private TableColumn<gamer,  String> name;

    @FXML
    private TableColumn<gamer,  Integer> point;
    @FXML
    private VBox Row;
    @FXML
    private TableView<gamer> table=new TableView<>();

    SimpleStringProperty username ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<gamer> data = FXCollections.observableArrayList(Database.getinformation());

        back.setOnAction(e->{
                try {
                    Back();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        name.setCellValueFactory(new PropertyValueFactory<gamer,String>("Name"));
        Email.setCellValueFactory(new PropertyValueFactory<gamer,String>("Email"));
        Rank.setCellValueFactory(new PropertyValueFactory<gamer,Integer>("Rank"));
        Age.setCellValueFactory(new PropertyValueFactory<gamer,Integer>("Age"));
        point.setCellValueFactory(new PropertyValueFactory<gamer,Integer>("point"));
        Ground.setCellValueFactory(new PropertyValueFactory<gamer,String>("Name"));
        table.setItems(data);





    }

    public void Back() throws IOException {
            AnchorPane root= FXMLLoader.load(this.getClass().getResource("/com/example/demo/loginPage.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            back.getScene().getWindow().hide();
        }

    }


    /*

     int i=1;


                Text name =new Text();
                name.setText(gamer.getName());

                name.setFill(Color.WHITE);
                name.setFont(Font.font("Cooper Black"));


                Text Point=new Text(String.valueOf(gamer.getPoint()));
                Point.setFill(Color.WHITE);

                Text Email=new Text(gamer.getEmial());
                Email.setFill(Color.WHITE);


                Text Rank=new Text(String.valueOf(i++));
                Rank.setFill(Color.WHITE);

                Text Ground =new Text(gamer.getGender());
                Ground.setFill(Color.WHITE);

                col.getChildren().addAll(name,Email,Ground,Point,Rank);

                Row.getChildren().add(col);
                System.out.println(gamer.getName()+" "+gamer.getEmial());

     */



