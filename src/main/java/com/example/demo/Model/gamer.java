package com.example.demo.Model;

import javafx.collections.ObservableList;

public class gamer  {
    private String gender;


    private int  age;

    private String name;
    private String email;



    private int point;



    String passWord;

    public gamer(){

    }
    public gamer(String name ,String passWord,String gernd,String email){
        this.gender=gernd;
        this.name=name;
        this.passWord=passWord;
        this.email=email;

    }
    public gamer(String name ,String passWord,String gernd,String email,int point){
        this.gender=gernd;
        this.name=name;
        this.passWord=passWord;
        this.email=email;
        this.point=point;

    }





    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmial() {
        return email;
    }

    public void setEmial(String emial) {
        this.email = emial;
    }


    public String getPassWord(){return this.passWord;}

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point+this.point;
    }
}
