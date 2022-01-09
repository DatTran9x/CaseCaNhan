package model;

import java.sql.Date;

public class Orders {
    private int id_orders;
    private int id_room;
    private int id_customer;
    private Date date_start;
    private Date date_end;
    private int money;
    private boolean status;

    public Orders() {
    }

    public Orders(int id_orders, int id_room, int id_customer, Date date_start, Date date_end, int money, boolean status) {
        this.id_orders = id_orders;
        this.id_room = id_room;
        this.id_customer = id_customer;
        this.date_start = date_start;
        this.date_end = date_end;
        this.money = money;
        this.status = status;
    }

    public Orders(int id_room, int id_customer, Date date_start, Date date_end) {
        this.id_room = id_room;
        this.id_customer = id_customer;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public int getId_orders() {
        return id_orders;
    }

    public void setId_orders(int id_orders) {
        this.id_orders = id_orders;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
