package com.example.userlogindatabaseweb.model;

public class User {

    private int id;
    private String userName;
    private String passWord;

    // fun
    public User(){}

    public User(int id, String userName, String passWord){
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }
}
