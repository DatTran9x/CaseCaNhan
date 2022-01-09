package dao;

import model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final Connection connection = GetConnection.getConnection();

    public List<Orders> findAll() {
        String findAll = "SELECT * FROM orders;";
        List<Orders> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_orders = rs.getInt("id_orders");
                int id_customer = rs.getInt("id_customer");
                int id_room = rs.getInt("id_room");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                int money = rs.getInt("money");
                boolean status_orders = rs.getBoolean("status_odrders");
                Orders orders = new Orders(id_orders, id_room, id_customer, date_start, date_end, money, status_orders);
                list.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save(Orders orders) {
        String save = "INSERT INTO orders (id_room, id_customer, date_start, date_end, money, status_odrders) VALUES (?, ?, ?, ?, ?,?);";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(save);
            ps.setInt(1, orders.getId_room());
            ps.setInt(2, orders.getId_customer());
            ps.setDate(3, orders.getDate_start());
            ps.setDate(4, orders.getDate_end());
            ps.setInt(5, orders.getMoney());
            ps.setBoolean(6, orders.isStatus());
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

    public void edit(Orders orders) {
        String edit = "UPDATE orders SET  id_room = ? , id_customer = ? , date_start = ? , date_end = ? , money = ? , status_orders = ? WHERE id_orders = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(edit);
            ps.setInt(1, orders.getId_room());
            ps.setInt(2, orders.getId_customer());
            ps.setDate(3, orders.getDate_start());
            ps.setDate(4, orders.getDate_end());
            ps.setInt(5, orders.getMoney());
            ps.setBoolean(6, orders.isStatus());
            ps.setInt(7, orders.getId_orders());
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

    public void delete(int id) {
        String delete = "DELETE FROM orders WHERE id_orders = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Orders> findOrdersByCustomerId(int id) {
        String find = "SELECT * FROM orders WHERE id_customer = ?;";
        List<Orders> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_orders = rs.getInt("id_orders");
                int id_customer = rs.getInt("id_customer");
                int id_room = rs.getInt("id_room");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                int money = rs.getInt("money");
                boolean status_orders = rs.getBoolean("status_odrders");
                Orders orders = new Orders(id_orders, id_room, id_customer, date_start, date_end, money, status_orders);
                list.add(orders);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Orders> findOrdersByRoom(int id){
        String find = "SELECT * FROM orders WHERE id_room = ?;";
        List<Orders> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_orders = rs.getInt("id_orders");
                int id_customer = rs.getInt("id_customer");
                int id_room = rs.getInt("id_room");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                int money = rs.getInt("money");
                boolean status_orders = rs.getBoolean("status_odrders");
                Orders orders = new Orders(id_orders, id_room, id_customer, date_start, date_end, money, status_orders);
                list.add(orders);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public Orders findOrderByOrderId(int id){
        String find = "SELECT * FROM orders WHERE id_orders = ?;";
        Orders orders = new Orders();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_orders = rs.getInt("id_orders");
                int id_customer = rs.getInt("id_customer");
                int id_room = rs.getInt("id_room");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                int money = rs.getInt("money");
                boolean status_orders = rs.getBoolean("status_odrders");
                orders = new Orders(id_orders, id_room, id_customer, date_start, date_end, money, status_orders);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public Orders findOrdersByRoomAndCustomers(int id_room, int id_customer) {
        String find = "SELECT * FROM orders WHERE id_room = ? AND id_customer = ?;";
        Orders orders = new Orders();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1,id_room);
            ps.setInt(2,id_customer);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_orders = rs.getInt("id_orders");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                int money = rs.getInt("money");
                boolean status_orders = rs.getBoolean("status_odrders");
                orders = new Orders(id_orders, id_room, id_customer, date_start, date_end, money, status_orders);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public int dateDiff(int id){
        String dateDiff = "SELECT DATEDIFF(?, ?) AS DateDiff;";
        String findAll = "SELECT * FROM orders WHERE id_orders = "+id;
        int date=0;
        try {
            PreparedStatement ps = connection.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            String dateStart = "";
            String dateEnd = "";
            while (rs.next()){
                dateStart = rs.getString("date_start");
                dateEnd = rs.getString("date_end");
            }
            ps = connection.prepareStatement(dateDiff);
            ps.setString(1,dateEnd);
            ps.setString(2,dateStart);
            rs = ps.executeQuery();
            while (rs.next()){
                date = rs.getInt("DateDiff");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return date;
    }

    public Orders getLastOrder() {
        String findAll = "SELECT * FROM hotel.orders ORDER BY id_orders DESC LIMIT 1;";
        Orders orders = new Orders();
        try {
            PreparedStatement ps = connection.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_orders = rs.getInt("id_orders");
                int id_customer = rs.getInt("id_customer");
                int id_room = rs.getInt("id_room");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                int money = rs.getInt("money");
                boolean status_orders = rs.getBoolean("status_odrders");
                orders = new Orders(id_orders, id_room, id_customer, date_start, date_end, money, status_orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Orders> findAvailableOrder() {
        String findAll = "SELECT * FROM hotel.orders WHERE status_orders=0";
        List<Orders> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_orders = rs.getInt("id_orders");
                int id_customer = rs.getInt("id_customer");
                int id_room = rs.getInt("id_room");
                Date date_start = rs.getDate("date_start");
                Date date_end = rs.getDate("date_end");
                int money = rs.getInt("money");
                boolean status_orders = rs.getBoolean("status_odrders");
                Orders orders = new Orders(id_orders, id_room, id_customer, date_start, date_end, money, status_orders);
                list.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void checkOut(int id) {
        String checkOut = "UPDATE orders SET status_odrders = 1 WHERE id_orders = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(checkOut);
            ps.setInt(1,id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
