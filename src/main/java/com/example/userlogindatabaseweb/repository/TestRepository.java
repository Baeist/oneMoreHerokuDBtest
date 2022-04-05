package com.example.userlogindatabaseweb.repository;

import com.example.userlogindatabaseweb.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class TestRepository {

    private String DBurl;
    private String userName;
    private String password;

    private Connection connection;

    public TestRepository(){
        setConnection();
    }

    public void setConnection(){
        setDBurl(System.getenv("spring.datasource.url"));
        setUserName(System.getenv("spring.datasource.user"));
        setPassword(System.getenv("spring.datasource.password"));
        try{
            connection = DriverManager.getConnection(DBurl, userName, password);
        }
        catch(SQLException s){
            System.out.println("Could not connect to database " + s);
        }
    }

    public User retrieveUserById(int id){

        User userById = new User();

        try{

            String sql = "SELECT * FROM usertest WHERE id =" + id + ";";

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
            id = rs.getInt(1);
            String userName = rs.getString(2);
            String passWord = rs.getString(3);

                userById = new User(id, userName, password);
            }

            }
        catch(SQLException s){
            System.out.println("Could not get user " + s);
        }


        return userById;
    }

    public void setDBurl(String DBurl) {
        this.DBurl = DBurl;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
