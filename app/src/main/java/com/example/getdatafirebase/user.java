package com.example.getdatafirebase;

public class user {
    public String name;
    public int phoneN;
    public String address;

    public user(String name, int phoneN, String address) {
        this.name = name;
        this.phoneN=phoneN;
        this.address=address;

    }
    public user(){}

    public int getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(int phoneN) {
        this.phoneN = phoneN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}