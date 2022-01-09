package service;

import dao.RoomDao;
import model.Room;

import java.sql.Date;
import java.util.List;

public class RoomService {
    private static final RoomDao rd = new RoomDao();

    public List<Room> findAll(){
        return rd.findAll();
    }

    public Room findById(int id){ return rd.findById(id);}

    public List<Room> findAvailableRoom(){
        return rd.findAvailableRoom();
    }

    public List<Room> findRoomByCustomer(String name){ return rd.finRoomByCustomer(name);}


    public List<Room> findUsingRoomByCustomerId(int id) {
        return rd.findUsingRoomByCustomerId(id);
    }

    public List<Room> findUsedRoomByCustomerId(int id) {
        return  rd.findUsedRoomByCustomerId(id);
    }

    public Room getRoomById(int id_room) {
        return rd.findById(id_room);
    }
}
