package com.example.demo.Database;

import com.example.demo.Model.gamer;
import java.sql.*;
import java.nio.channels.ConnectionPendingException;
import java.util.ArrayList;


public class Database {


        public static Connection connection;



        public static Statement statement;
    private void Database(){}





/*this is for Start Connection with hangman */
    public static  void StartConnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hangman","root","");
            statement=connection.createStatement();

        }catch (SQLException | ClassNotFoundException e){
            e.getMessage();
        }
    }



    /*this is for End Connection with hangman */
    public static void EndConnection(){
        try {
            if (connection != null) {

                connection.close();

            }
        }catch (Exception e){
            e.getMessage();
        }
    }


    public static void insertUser(gamer game){

        String name =game.getName();
        String passWord =game.getPassWord();
        String ground=game.getGender();
        String email=game.getEmial();
        System.out.println(ground);
        StartConnection();
            try {
                String query=" INSERT INTO gamer (username,ground,point,password,email) values ('%s','%s',%s,'%s','%s') ";
                query=String.format(query,name,ground,0,passWord,email);
                statement.execute(query);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            EndConnection();
    }

    public static ArrayList<gamer> getinformation(){
        ArrayList<gamer> Gamers=new ArrayList<>();

        StartConnection();
        try{
            ResultSet resultSet=  statement.executeQuery(String.format("Select * from gamer "));
            while (resultSet.next()){
                Gamers.add(new gamer(resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("ground")
                        ,resultSet.getString("email"),resultSet.getInt("point")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        EndConnection();
        return   Gamers;
    }


    public static void updata(int point ,gamer gamer){
        StartConnection();
        String name= gamer.getName();
        try {

        String query="update gamer set point=%s where username='%s'";
        query=String.format(query,point,name);

            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("problem in SQL");
            throw new RuntimeException(e);
        }

        EndConnection();
    }



}
