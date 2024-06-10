package com.example.demo.controller;

import com.example.demo.Database.Database;
import com.example.demo.Model.gamer;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.ObjectMapper;

import static com.mysql.cj.conf.PropertyKey.logger;


public class PlayGame implements Initializable {



    @FXML
    private Button back;
    gamer gamer =new gamer();

    ArrayList<String> mis = new ArrayList<>();

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

    public String word;
    public double fall = 0;
    @FXML
    private Label score;

    @FXML
    private Label answerHint;

    public int  Grade=gamer.getPoint();;
    @FXML
    private Button hint;

    public ArrayList<TextField> Word = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        score.setText("");

        back.setOnAction(e->{
            BackHome();
            back.getScene().getWindow().hide();
        });

        Answer.setSpacing(10);

        start.setOnAction(e -> {
            ClearAll();
           do {
               word=getWord();
           }while (word.length()>6);

            for (int i = 0; i < word.length(); i++) {
                fall = 0;
                TextField a = new TextField();
                a.setPrefSize(24, 25);
                a.setStyle("-fx-background-color:#00fcf8 ");

                Word.add(a);
                Answer.getChildren().add(a);
            }
        });




        check.setOnAction(e -> {
            int f=0;
            if (Word.size() != 0) {


                for (int i = 0; i < word.length(); i++) {

                    if (Word.get(i).getText().equals(String.valueOf(word.charAt(i)))) {
                        Correct(i);
                        f++;
                    } else if (Word.get(i).getText().equals("") || Befor(Word.get(i).getText())) {

                    } else {
                        fall++;
                        Fall();
                        mis.add(Word.get(i).getText());

                    }
                }
                if (f==Word.size()){


                    Grade=Grade+f+gamer.getPoint();
                    gamer.setPoint(Grade);
                    System.out.println(gamer.getName());
                    Database.updata(Grade,gamer);
                    score.setText(String.valueOf(Grade));

                    f=0;
                }
            }
        });
        hint.setOnAction(e->{
            Random rand = new Random();
            int j=rand.nextInt(word.length());
            answerHint.setText("Char AT " +j+" is "+word.charAt(j));
            Word.get(j).setText(String.valueOf(word.charAt(j)));
            Word.get(j).setDisable(true);
            fall+=0.5;
            Fall();
        });
    }

    private void BackHome() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/loginPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    private boolean Befor(String string) {
        boolean b = false;
        for (String s : mis) {
            if (string.equals(s)) {
                b = true;
                break;
            }
        }
        return b;
    }

    private void ClearAll() {
        int j = Word.size();
        System.out.println(j);
        fall = 0;
        Answer.getChildren().clear();
        Word.clear();
        visible();

    }

    private void Fall() {
        visible();
        switch ((int)fall) {
            case 6: {
                six.setVisible(true);
                try {
                    gameOver();
                    back.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case 5:
                five.setVisible(true);
            case 4:
                four.setVisible(true);
            case 3:
                three.setVisible(true);
            case 2:
                two.setVisible(true);
            case 1:
                one.setVisible(true);
                break;

        }
    }

    private void gameOver() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/Gameover.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void visible() {
        six.setVisible(false);
        three.setVisible(false);
        five.setVisible(false);
        four.setVisible(false);
        two.setVisible(false);
        one.setVisible(false);
    }

    private void Correct(int i) {
        Word.get(i).setDisable(true);
        Word.get(i).setStyle("-fx-background-color: Green");

    }


    public String getWord() {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/randomword");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", "uvpIFPXS7SEX6mroJq8uxPyUf5q9vyWhLxfv4D6U");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);

                System.out.println(root.path("word").asText());
                return root.path("word").asText();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    }
