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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private VBox Col;
    @FXML
    private TableView<gamer> table=new TableView<>();

    SimpleStringProperty username ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<gamer> gamers=new ArrayList<>(Database.getinformation());
        back.setOnAction(e->{
                try {
                    Back();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        Collections.sort(gamers, new Comparator<gamer>() {
            @Override
            public int compare(gamer s2, gamer s1) {
                return Integer.compare(s1.getPoint(), s2.getPoint());
            }
        });
        int i=1;


        for (gamer gamer:gamers) {


            HBox row = new HBox();
            row.setSpacing(20);
            Label username = new Label(gamer.getName());
            username.setPrefSize(100,30);
            username.setTextFill(Color.WHITE);
            username.setFont(Font.font(15));
            username.setFont(Font.font("Cooper Black"));


            Label point  = new Label(String.valueOf(gamer.getPoint()));
            point.setPrefSize(100,30);
            point.setTextFill(Color.WHITE);
            point.setFont(Font.font(15));
            point.setFont(Font.font("Cooper Black"));


            Label Ground=new Label(gamer.getGender());
            Ground.setPrefSize(100,30);
            Ground.setTextFill(Color.WHITE);
            Ground.setFont(Font.font(15));
            Ground.setFont(Font.font("Cooper Black"));


            Label email=new Label(gamer.getEmial());
            email.setPrefSize(100,30);
            email.setTextFill(Color.WHITE);
            email.setFont(Font.font(15));
            email.setFont(Font.font("Cooper Black"));

            Label Rank=new Label(String.valueOf(i++));
            Rank.setPrefSize(100,30);
            Rank.setTextFill(Color.WHITE);
            Rank.setFont(Font.font(15));
            Rank.setFont(Font.font("Cooper Black"));


            row.getChildren().addAll(username,email,Ground,point,Rank);
            Col.getChildren().add(row);

        }


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



