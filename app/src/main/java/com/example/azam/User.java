package com.example.azam;

public class User {
    public String uid,email,password,bdate,username,userphno,useraddress;

    public User() {
    }

    public User(String uid, String email, String password, String bdate, String username, String userphno, String useraddress) {
        this.uid = uid;
        this.email = email;
       // this.password = password;
        this.bdate = bdate;
        this.username = username;
        this.userphno = userphno;
        this.useraddress = useraddress;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphno() {
        return userphno;
    }

    public void setUserphno(String userphno) {
        this.userphno = userphno;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }
}
