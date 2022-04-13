package com.example.zboruri.Flights;

public class Flight {

    private int id;
    private String start;
    private String destination;
    private int price;

    public Flight(int id, String start, String destination, int price) {
        this.id = id;
        this.start = start;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        /*return "Flight " +
                "id = " + id +
                ", orasPlecare = " + start +
                ", destinatie = " + destination +
                ", pret = " + price +
                " euro";*/
        return start + " -> " + destination + "    " + price + " euro";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
