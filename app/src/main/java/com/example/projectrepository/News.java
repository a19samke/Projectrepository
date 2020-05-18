package com.example.projectrepository;

public class News {
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private int cost;
    private String auxdata;



    public News(String id) {
    }

    public News(String id, String name, String type, String company, String location, int cost, String auxdata) {
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



    @Override
    public String toString() {
        return "ID"+ "\n" + ID + "\n" + "Name" + "\n" +  name + "\n" + "type" + "\n"  + type +
                "\n" +" company " + "\n" +company + "\n" + "location"+ "\n"+ location+ "\n" + "cost" + "\n" + cost + "\n" + "auxdata" + "\n" + auxdata;
    }
}
