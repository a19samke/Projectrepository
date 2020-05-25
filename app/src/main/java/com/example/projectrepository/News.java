package com.example.projectrepository;

public class News {
    private String ID;
   private String name;
    private String type;
    private String company;
    private String location;
    private String auxdata;
    private int cost;


    public News(String ID, String name, String type, String company, String location, String auxdata, int cost) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.company = company;
        this.location = location;
        this.auxdata = auxdata;
        this.cost = cost;
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

    public String getAuxdata() {
        return auxdata;
    }

    public int getCost() {
        return cost;
    }



    @Override
    public String toString() {
        return  ID + "\n"  +  name + "\n" + "Type" + "\n"  + type + "\n" + location+ "\n" + "\n" + "Read:) Auxdata" + "\n" + auxdata + "\n" + "\n" + "Cost" + "\n" + cost;
    }
}
