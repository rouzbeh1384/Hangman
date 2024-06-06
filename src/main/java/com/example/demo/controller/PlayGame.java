package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.Text;

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

    public String word ;
    public int fall =0;
    public boolean test=true;

    @FXML
    private Text score;


    public ArrayList<TextField>Word=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Answer.setSpacing(10);

        start.setOnAction(e->{
            ClearAll();
             word =getWord();

            for(int i=0;i<word.length();i++){
                fall=0;
                TextField a=new TextField();
                a.setPrefSize(24,25 );
                a.setStyle("-fx-background-color:#00fcf8 ");

                Word.add(a);
                Answer.getChildren().add(a);
            }
        });

        check.setOnAction(e->{
            if (Word.size()!=0) {
                for (int i = 0; i < word.length(); i++) {

                    if (Word.get(i).getText().equals(String.valueOf(word.charAt(i)))) {
                        Correct(i);
                    } else if (Word.get(i).getText().equals("")) {

                    } else {
                        fall++;
                        Fall();

                    }
                }

            }

        });


    }

    private void ClearAll() {
        int j=Word.size();
        System.out.println(j);
        fall=0;
        Answer.getChildren().clear();
        Word.clear();
        visible();

    }

    private void Fall() {
        visible();
        switch (fall){
            case 6:six.setVisible(true);
            case 5:five.setVisible(true);
            case 4:four.setVisible(true);
            case 3:three.setVisible(true);
            case 2:two.setVisible(true);
            case 1:one.setVisible(true);
                break;

        }
    }

    private void visible() {
        six.setVisible(false);
        three.setVisible(false);
        five.setVisible(false);
        four.setVisible(false);
        two.setVisible(false);
        one.setVisible(false);
    }

    private void Correct(int i ) {
        Word.get(i).setDisable(true);
        Word.get(i).setStyle("-fx-background-color: Green");

    }


    public String getWord(){
        String word="rouzbeh";
        // TODO use api and get word


        return word;

    }



}
