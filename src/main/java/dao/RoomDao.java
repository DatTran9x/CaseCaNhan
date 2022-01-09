package dao;

import model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {
    private static final Connection connection = GetConnection.getConnection();

    public List<Room> findAll(){
        String findAll = "SELECT * FROM room;";
        List<Room> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_room = rs.getInt("id_room");
                String name = rs.getString("name_room");
                int beds = rs.getInt("beds");
                int money = rs.getInt("money");
                Room room = new Room(id_room,name,beds,money);
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Room findById(int id) {
        String find = "SELECT * FROM room WHERE id_room = ?";
        Room room = new Room();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_room = rs.getInt("id_room");
                String name = rs.getString("name_room");
                int beds = rs.getInt("beds");
                int money = rs.getInt("money");
                room = new Room(id_room, name, beds, money);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return room;
    }

    public List<Room> findAvailableRoom(){
        String findAll = "SELECT * FROM room  WHERE status_room = 0;";
        List<Room> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_room = rs.getInt("id_room");
                String name = rs.getString("name_room");
                int beds = rs.getInt("beds");
                int money = rs.getInt("money");
                Room room = new Room(id_room,name,beds,money);
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Room> finRoomByCustomer(String name) {
        String find = "SELECT * FROM room r JOIN orders o ON r.id_room = o.id_room JOIN customer c ON o.id_customer = c.id_customer WHERE name_customer LIKE '%"+name+"%';";
        List<Room> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_room = rs.getInt("id_room");
                String name_room = rs.getString("name_room");
                int beds = rs.getInt("beds");
                int money = rs.getInt("money");
                Room room = new Room(id_room,name_room,beds,money);
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Room> findUsingRoomByCustomerId(int id) {
        String find = "SELECT * FROM room r JOIN orders o ON r.id_room = o.id_room  WHERE  id_customer = ? AND status_odrders = 0;";
        List<Room> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_room = rs.getInt("id_room");
                String name_room = rs.getString("name_room");
                int beds = rs.getInt("beds");
                int money = rs.getInt("money");
                Room room = new Room(id_room,name_room,beds,money);
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Room> findUsedRoomByCustomerId(int id) {
        String find = "SELECT * FROM room r JOIN orders o ON r.id_room = o.id_room  WHERE  id_customer = ? AND status_odrders = 1;";
        List<Room> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(find);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_room = rs.getInt("id_room");
                String name_room = rs.getString("name_room");
                int beds = rs.getInt("beds");
                int money = rs.getInt("money");
                Room room = new Room(id_room,name_room,beds,money);
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
