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

    public News(String id, String type, String name, String location, String auxdata, int cost) {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAuxdata() {
        return auxdata;
    }

    public void setAuxdata(String auxdata) {
        this.auxdata = auxdata;
    }

    @Override
    public String toString() {
        return "News{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", cost=" + cost +
                ", auxdata='" + auxdata + '\'' +
                '}';
    }
}
