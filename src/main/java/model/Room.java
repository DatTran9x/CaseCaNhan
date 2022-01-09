package model;

public class Room {
    private int id_room;
    private String name;
    private int beds;
    private int price;
    private boolean status;

    public Room() {
    }

    public Room(int id_room, String name, int beds, int price) {
        this.id_room = id_room;
        this.name = name;
        this.beds = beds;
        this.price = price;
    }

    public Room(String name, int beds, int price) {
        this.name = name;
        this.beds = beds;
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
