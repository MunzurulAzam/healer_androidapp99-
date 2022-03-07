package com.example.azam;

public class Doctor {
    public String uid,doctorname,doctoremail,doctorpassword,doctorphno,doctorqualification,doctorinstitution,
            doctorspecialist,doctorhospitalname,doctoraddress;

    public Doctor() {
    }

    public Doctor(String uid, String doctorname, String doctoremail, String doctorpassword, String doctorphno, String doctorqualification, String doctorinstitution, String doctorspecialist, String doctorhospitalname, String doctoraddress) {
        this.uid = uid;
        this.doctorname = doctorname;
        this.doctoremail = doctoremail;
        //this.doctorpassword = doctorpassword;
        this.doctorphno = doctorphno;
        this.doctorqualification = doctorqualification;
        this.doctorinstitution = doctorinstitution;
        this.doctorspecialist = doctorspecialist;
        this.doctorhospitalname = doctorhospitalname;
        this.doctoraddress = doctoraddress;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDoctoremail() {
        return doctoremail;
    }

    public void setDoctoremail(String doctoremail) {
        this.doctoremail = doctoremail;
    }

    public String getDoctorphno() {
        return doctorphno;
    }

    public void setDoctorphno(String doctorphno) {
        this.doctorphno = doctorphno;
    }

    public String getDoctorqualification() {
        return doctorqualification;
    }

    public void setDoctorqualification(String doctorqualification) {
        this.doctorqualification = doctorqualification;
    }

    public String getDoctorinstitution() {
        return doctorinstitution;
    }

    public void setDoctorinstitution(String doctorinstitution) {
        this.doctorinstitution = doctorinstitution;
    }

    public String getDoctorspecialist() {
        return doctorspecialist;
    }

    public void setDoctorspecialist(String doctorspecialist) {
        this.doctorspecialist = doctorspecialist;
    }

    public String getDoctorhospitalname() {
        return doctorhospitalname;
    }

    public void setDoctorhospitalname(String doctorhospitalname) {
        this.doctorhospitalname = doctorhospitalname;
    }

    public String getDoctoraddress() {
        return doctoraddress;
    }

    public void setDoctoraddress(String doctoraddress) {
        this.doctoraddress = doctoraddress;
    }
}
