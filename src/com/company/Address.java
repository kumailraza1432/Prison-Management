package com.company;

public class Address {
    String city;
    String house;
    String street;
    String sector;
    public Address(){
        city="Islamabad";
        house="287-b";
        street="30-A";
        sector="g6/2";
    }
    public Address(String city, String house, String street, String sector) {
        this.city = city;
        this.house = house;
        this.street = street;
        this.sector = sector;
    }
    public String getCity() {
        return city;
    }
    public String getHouse() {
        return house;
    }
    public String getStreet() {
        return street;
    }
    public String getSector() {
        return sector;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
}
