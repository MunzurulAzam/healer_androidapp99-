package com.example.azam;

public class Acceptmodel {
    String Uid,name,email,phno;

    public Acceptmodel() {
    }

    public Acceptmodel(String uid, String name, String email, String phno) {
        Uid = uid;
        this.name = name;
        this.email = email;
        this.phno = phno;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
