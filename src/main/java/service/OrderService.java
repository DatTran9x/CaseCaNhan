package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.OrderDao;
import model.Orders;

import java.util.List;

public class OrderService {
    private static final OrderDao orderDao = new OrderDao();

    public List<Orders> findAll() {
        return orderDao.findAll();
    }

    public void save(Orders orders) {
        orderDao.save(orders);
    }

    public void edit(Orders orders) {
        orderDao.edit(orders);
    }

    public void delete(int id){
        orderDao.delete(id);
    }

    public List<Orders> findOrderByCustomer(int id){
        return orderDao.findOrdersByCustomerId(id);
    }

    public List<Orders> findOrderByRoom(int id){
        return orderDao.findOrdersByRoom(id);
    }

    public Orders findOrderByOrderId(int id){
        return orderDao.findOrderByOrderId(id);
    }

    public Orders findOrderByRoomAndCustomer(int id_room,int id_customer){
        return orderDao.findOrdersByRoomAndCustomers(id_room,id_customer);
    }


    public int dateDiff(int id) {
        return orderDao.dateDiff(id);
    }

    public Orders getLastOrder() {
        return orderDao.getLastOrder();
    }

    public List<Orders> findAvailableOrder() {
        return orderDao.findAvailableOrder();
    }

    public void checkOut(int id) {
        orderDao.checkOut(id);
    }
}
