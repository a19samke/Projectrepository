package com.example.projectrepository;

public class News {
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private int cost;
    private String auxdata;

    public News(String ID, String name, String type, String company, String location, int cost, String auxdata) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.company = company;
        this.location = location;
        this.cost = cost;
        this.auxdata = auxdata;
    }

    public News(String id) {
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public int getCost() {
        return cost;
    }

    public String getAuxdata() {
        return auxdata;
    }

    @Override
    public String toString() {
        return "ID"+ "\n" + ID + "\n" + "Name" + "\n"+  name + "\n" + "Size" + "\n"  + auxdata + "\n" +" Location " + "\n" +location;
    }
}
