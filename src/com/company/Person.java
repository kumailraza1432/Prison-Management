package com.company;

public class Person {
        String FirstName;
        String LastName;
        String gender;
        Address ad;
        public Person(){
            FirstName="Kumail";
            LastName="raza";
            gender = "Male";
            ad=new Address();
        }
        public Person(String FirstName, String LastName, Address ad,String gender) {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.ad = ad;
            this.gender=gender;
        }
        public String getFirstName() {
            return FirstName;
        }
        public String getLastName() {
            return LastName;
        }
        public Address getAd() {
            return ad;
        }
        public String getGender() {
            return gender;
        }
        public void setFirstName(String FirstName) {
            this.FirstName = FirstName;
        }
        public void setLastName(String LastName) {
            this.LastName = LastName;
        }
        public void setAd(Address ad) {
            this.ad = ad;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        public void display(){
            System.out.println("Name= "+FirstName+" "+LastName);
            System.out.println("Gender = "+gender);
            System.out.println("Address= "+ad.getCity()+" "+ad.getHouse()+" "+ad.getSector()+" "+ad.getStreet());
        }
}
