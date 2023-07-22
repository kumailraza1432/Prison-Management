package com.company;

import java.io.Serializable;

public class Jailor extends Person implements Serializable {
    String id;
    public Jailor(){
        super();
        id="123";
    }
    public Jailor(String id, String FirstName, String LastName, Address ad, String gender) {
        super(FirstName, LastName, ad, gender);
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("id="+id);
    }
}
