package com.company;

import java.io.Serializable;
public class Prisoner extends Person implements Serializable {
    String id;
    String crime;
    int cellno;
    public Prisoner(){
        super();
        id="123";
        crime="Theft";
        cellno=123;
    }
    public Prisoner(String id, String crime, String FirstName, String LastName, Address ad, String gender, int cellno) {
        super(FirstName, LastName, ad, gender);
        this.id = id;
        this.crime = crime;
        this.cellno=cellno;
    }
    public void setCellno(int cellno) {
        this.cellno = cellno;
    }
    public int getCellno() {
        return cellno;
    }
    public String getId() {
        return id;
    }
    public String getFelony() {
        return crime;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setFelony(String crime) {
        this.crime = crime;
    }
    @Override
    public void display(){
        super.display();
        System.out.println(id);
        System.out.println(crime);
        System.out.println(cellno);
    }
}
