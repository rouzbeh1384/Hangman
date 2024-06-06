package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayGame implements Initializable {

    @FXML
    private Button check;

    @FXML
    private Rectangle five;

    @FXML
    private Rectangle four;

    @FXML
    private Group one;

    @FXML
    private Rectangle six;

    @FXML
    private Button start;

    @FXML
    private Rectangle three;

    @FXML
    private Rectangle two;
    @FXML
    private HBox Answer;


    int fall ;
    public ArrayList<TextField>Word=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Answer.setSpacing(10);

        start.setOnAction(e->{
            String word =getWord();
            for(int i=0;i<word.length();i++){
                TextField a=new TextField();
                a.setPrefSize(24,25 );
                Word.add(a);

                Answer.getChildren().add(a);
            }




        });




    }

    public String getWord(){
        String word="Java";


        return word;

    }



}
