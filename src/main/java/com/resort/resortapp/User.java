package com.resort.resortapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User{
    private int id;
    private String phone;
    private String visit;
    private String exit;
    private int members;
    public User(){}
    public User(int id,String phone, int members,String visit,String exit){
        setId(id);
        setPhone(phone);
        setMembers(members);
        setVisit(visit);
        setExit(exit);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setVisit(String visit) {
        this.visit = visit;
        
    }
    public String getVisit() {
        return this.visit;

    }
    public void setExit(String exit) {
        this.exit=exit;
    }
    public String getExit() {
        return this.exit;
    }
    public void setMembers(int members) {
        this.members = members;
    }
    public int getMembers() {
        return members;
    }
    @Override
    public String toString() {
        return "id: "+this.id+" phone: "+this.phone+" visit: "+this.visit+" exit: "+this.exit
        +" members: "+this.members;
    }
}