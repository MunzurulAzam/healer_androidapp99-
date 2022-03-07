package com.example.azam;

public class model {
    String doctoremail,doctoraddress,doctorhospitalname,doctorinstitution,doctorname,doctorphno,doctorqualification,doctorspecialist;

    model()
    {

    }
    public model(String doctoremail, String doctoraddress, String doctorhospitalname, String doctorinstitution, String doctorname, String doctorphno, String doctorqualification, String doctorspecialist) {
        this.doctoremail = doctoremail;
        this.doctoraddress = doctoraddress;
        this.doctorhospitalname = doctorhospitalname;
        this.doctorinstitution = doctorinstitution;
        this.doctorname = doctorname;
        this.doctorphno = doctorphno;
        this.doctorqualification = doctorqualification;
        this.doctorspecialist = doctorspecialist;
    }

    public String getDoctoremail() {
        return doctoremail;
    }

    public void setDoctoremail(String doctoremail) {
        this.doctoremail = doctoremail;
    }

    public String getDoctoraddress() {
        return doctoraddress;
    }

    public void setDoctoraddress(String doctoraddress) {
        this.doctoraddress = doctoraddress;
    }

    public String getDoctorhospitalname() {
        return doctorhospitalname;
    }

    public void setDoctorhospitalname(String doctorhospitalname) {
        this.doctorhospitalname = doctorhospitalname;
    }

    public String getDoctorinstitution() {
        return doctorinstitution;
    }

    public void setDoctorinstitution(String doctorinstitution) {
        this.doctorinstitution = doctorinstitution;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
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

    public String getDoctorspecialist() {
        return doctorspecialist;
    }

    public void setDoctorspecialist(String doctorspecialist) {
        this.doctorspecialist = doctorspecialist;
    }
}
