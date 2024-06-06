package com.example.demo.Model;

public class gamer {
    private int Age;
    private boolean gender;

    private int Id =-1;


    private String name;
    private String emial;

    String passWord;

    public gamer(){

    }
    public gamer(int age ,String name ,String passWord,Boolean gernd){
        this.gender=gernd;
        this.name=name;
        this.passWord=passWord;
        this.Age=age;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }


    public String getPassWord(){return this.passWord;}

}
