/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

/**
 *
 * @author shibo
 */
public class User {
    
    private Integer id;
    private String userName;
    private String pathOfPic;

    public User(Integer id, String userName, String pathOfPic) {
        this.id = id;
        this.userName = userName;
        this.pathOfPic = pathOfPic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPathOfPic() {
        return pathOfPic;
    }

    public void setPathOfPic(String pathOfPic) {
        this.pathOfPic = pathOfPic;
    }
    
}
