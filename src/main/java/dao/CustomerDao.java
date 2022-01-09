package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final Connection connection = GetConnection.getConnection();

    public List<Customer> findAll(){
        String findAll = "SSELECT * FROM orders;";
        List<Customer> list = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_customer = rs.getInt("id_customer");
                String name = rs.getString("name_customer");
                int age = rs.getInt("age");
                String phone = rs.getString("sdt");
                String cmtnd = rs.getString("cmtnd");
                Customer customer = new Customer(id_customer,name,age,phone,cmtnd);
                list.add(customer);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public void save(Customer customer) {
        String save = "INSERT INTO customer (name_customer, age, sdt, cmntnd) VALUES (?, ?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(save);
            ps.setString(1,customer.getName());
            ps.setInt(2,customer.getAge());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getCmtnd());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    public void edit(Customer customer){
        String edit = "UPDATE customer SET name_customer = ?, age = ?, sdt = ?, cmntnd = ? WHERE id_customer = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps =connection.prepareStatement(edit);
            ps.setString(1,customer.getName());
            ps.setInt(2,customer.getAge());
            ps.setString(3,customer.getPhone());
            ps.setString(4,customer.getCmtnd());
            ps.setInt(5,customer.getId_customer());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    public void delete(int id){
        String delete = "DELETE FROM customer WHERE id_customer = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1,id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    public List<Customer> findByName(String name){
        String find = "SELECT * FROM customer WHERE name_customer LIKE '%"+name+"%';";
        List<Customer> list = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(find);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_customer = rs.getInt("id_customer");
                String name_customer = rs.getString("name_customer");
                int age = rs.getInt("age");
                String phone = rs.getString("sdt");
                String cmtnd = rs.getString("cmntnd");
                Customer customer = new Customer(id_customer,name_customer,age,phone,cmtnd);
                list.add(customer);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Customer checkCustomer(String cmtnd){
        String find = "SELECT * FROM customer WHERE cmntnd = ?;";
        Customer customer = null;
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setString(1,cmtnd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_customer = rs.getInt("id_customer");
                String name_customer = rs.getString("name_customer");
                int age = rs.getInt("age");
                String phone = rs.getString("sdt");
                customer = new Customer(id_customer,name_customer,age,phone,cmtnd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    public List<Customer> findAllBookedCustomer() {
        String find = "SELECT * FROM customer c JOIN orders o ON c.id_customer = o.id_customer WHERE status_odrders = 0;";
        List<Customer> list = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(find);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_customer = rs.getInt("id_customer");
                String name_customer = rs.getString("name_customer");
                int age = rs.getInt("age");
                String phone = rs.getString("sdt");
                String cmtnd = rs.getString("cmntnd");
                Customer customer = new Customer(id_customer,name_customer,age,phone,cmtnd);
                list.add(customer);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Customer findCustomerById(int id_customer) {
        String find = "SELECT * FROM customer WHERE id_customer = ?;";
        Customer customer = null;
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1,id_customer);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name_customer = rs.getString("name_customer");
                int age = rs.getInt("age");
                String phone = rs.getString("sdt");
                String cmtnd = rs.getString("cmntnd");
                customer = new Customer(id_customer,name_customer,age,phone,cmtnd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
