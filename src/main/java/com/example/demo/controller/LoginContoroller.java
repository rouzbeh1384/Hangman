package com.example.demo.controller;

import com.example.demo.Database.Database;
import com.example.demo.Model.gamer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginContoroller implements Initializable {
    @FXML
    private Button Start;

    @FXML
    private Button back;

    @FXML
    private PasswordField passWord;
    @FXML
    private PasswordField passWord1;
    @FXML
    private Text result;

    @FXML
    private ComboBox<String> ground=new ComboBox<>();

    @FXML
    private TextField userName;

    @FXML
    private Text passWordCheck;



    @FXML
    private TextField email;
    @FXML
    private Text emialCheck;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ground.getItems().addAll( "Man","Woman");

        System.out.println(ground.getItems());


        back.setOnAction(e->{
            try {
                BackHome();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Start.setOnAction(e->{
            try {
                StartGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });




    }


    private void BackHome () throws IOException {
        AnchorPane root=FXMLLoader.load(this.getClass().getResource("/com/example/demo/loginPage.fxml"));
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        back.getScene().getWindow().hide();
    }

    private void StartGame()throws IOException{
       String user= userName.getText();
       boolean checkRepyt=false;
        ArrayList<gamer> gamers=new ArrayList<>();
        gamers=Database.getinformation();


        for (gamer gamer : gamers) {
            if (user.equals(gamer.getName())) {
                checkRepyt = true;
                break;
            }
        }



        if (!user.isEmpty()) {
            if(!checkRepyt) {
                if (passWord.getText().equals(passWord1.getText())) {
                    if (!email.getText().isEmpty()) {
                        if (REgex(email.getText())) {

                            if (!ground.getValue().isEmpty()) {
                                Start.getScene().getWindow().hide();

                                Database.insertUser(new gamer(userName.getText(), passWord.getText(), ground.getValue().toString(), email.getText()));

                                StartGameFXML();
                            }
                        } else {
                            emialCheck.setText("inter the correct email");
                            emialCheck.setFill(Color.RED);

                        }
                    }
                    else {
                        emialCheck.setText("please write your email");
                        emialCheck.setFill(Color.RED);
                    }
                }else {
                    passWordCheck.setText("not equal");
                    passWordCheck.setFill(Color.RED);
                }
            }else {
                result.setText("change Username");
                result.setFill(Color.RED);
            }

        }
    }

    private boolean REgex(String email) {


            String regex = "\\w*@\\w*\\.\\w{1,4}\\b";  // TODO

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (matcher.find()) {
                return true;
            }
            else{
                return false;
            }


    }

    private void StartGameFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/enter2Game.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){e.printStackTrace();}
    }

}
