package model;

public class Customer {
    private int id_customer;
    private String name;
    private int age;
    private String phone;
    private String cmtnd;

    public Customer() {
    }

    public Customer(String name, int age, String phone, String cmtnd) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.cmtnd = cmtnd;
    }

    public Customer(int id_customer, String name, int age, String phone, String cmtnd) {
        this.id_customer = id_customer;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.cmtnd = cmtnd;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmtnd() {
        return cmtnd;
    }

    public void setCmtnd(String cmtnd) {
        this.cmtnd = cmtnd;
    }
}
