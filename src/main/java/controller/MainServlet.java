package controller;

import model.Customer;
import model.Orders;
import model.Room;
import service.CustomerService;
import service.OrderService;
import service.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet", value = "/home")
public class MainServlet extends HttpServlet {
    private static final RoomService rs = new RoomService();
    private static final CustomerService cs = new CustomerService();
    private static final OrderService os = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "findRoom":
                findRoom(req, resp);
                break;
            case "rent":
                rentForm(req, resp);
                break;
            case "delete":
                deleteForm(req, resp);
                break;
            case "checkin":
                checkInForm(req, resp);
                break;
            case "checkout":
                checkOutForm(req, resp);
                break;
            case "getOrder":
                getOrder(req, resp);
                break;
            case "checkinorder":
                checkInOrder(req, resp);
                break;
            case "getcheckout":
                getCheckOut(req, resp);
                break;
            case "checkoutorder":
                getCheckOutOrder(req, resp);
                break;
            case "payment":
                payment(req, resp);
                break;
            default:
                showHomepage(req, resp);
        }
    }

    private void payment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        os.checkOut(id);
        showHomepage(req, resp);
    }

    private void getCheckOutOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_customer = Integer.parseInt(req.getParameter("id_customer"));
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        Customer customer = cs.getCustomerById(id_customer);
        Room room = rs.getRoomById(id_room);
        Orders order = os.findOrderByRoomAndCustomer(id_room, id_customer);
        req.setAttribute("customer", customer);
        req.setAttribute("room", room);
        req.setAttribute("order", order);
        RequestDispatcher rd = req.getRequestDispatcher("/view/checkoutform.jsp");
        rd.forward(req, resp);
    }

    private void getCheckOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_customer = Integer.parseInt(req.getParameter("id"));
        Customer customer = cs.getCustomerById(id_customer);
        List<Orders> listO = os.findOrderByCustomer(id_customer);
        List<Room> listR = new ArrayList<>();
        for (Orders o : listO) {
            Room room = rs.findById(o.getId_room());
            listR.add(room);
        }
        req.setAttribute("customer", customer);
        req.setAttribute("list", listR);
        RequestDispatcher rd = req.getRequestDispatcher("view/checkoutroom.jsp");
        rd.forward(req, resp);
    }

    private void checkOutForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = cs.findAllBookedCustomer();
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("/view/checkout.jsp");
        rd.forward(req, resp);
    }

    private void checkInOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_customer = Integer.parseInt(req.getParameter("id_customer"));
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        Customer customer = cs.getCustomerById(id_customer);
        Room room = rs.getRoomById(id_room);
        Orders order = os.findOrderByRoomAndCustomer(id_room, id_customer);
        req.setAttribute("customer", customer);
        req.setAttribute("room", room);
        req.setAttribute("order", order);
        RequestDispatcher rd = req.getRequestDispatcher("/view/checkinform.jsp");
        rd.forward(req, resp);
    }

    private void getOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_customer = Integer.parseInt(req.getParameter("id"));
        Customer customer = cs.getCustomerById(id_customer);
        List<Orders> listO = os.findOrderByCustomer(id_customer);
        List<Room> listR = new ArrayList<>();
        for (Orders o : listO) {
            Room room = rs.findById(o.getId_room());
            listR.add(room);
        }
        req.setAttribute("customer", customer);
        req.setAttribute("list", listR);
        RequestDispatcher rd = req.getRequestDispatcher("view/findroom.jsp");
        rd.forward(req, resp);
    }


    private void checkInForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Customer> list = cs.findAllBookedCustomer();
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("/view/checkin.jsp");
        rd.forward(req, resp);
    }

    private void deleteForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/view/checkout.jsp");
    }

    private void findRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Room> listUsingRoom = rs.findUsingRoomByCustomerId(id);
        List<Room> listUsedRoom = rs.findUsedRoomByCustomerId(id);
        req.setAttribute("usingRoom", listUsingRoom);
        req.setAttribute("usedRoom", listUsedRoom);
        RequestDispatcher rd = req.getRequestDispatcher("/view/find.jsp");
        rd.forward(req, resp);
    }

    private void rentForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Room room = rs.findById(id);
        req.setAttribute("room", room);
        RequestDispatcher rd = req.getRequestDispatcher("/view/rent.jsp");
        rd.forward(req, resp);
    }

    private void searchByRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void showHomepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> list = rs.findAvailableRoom();
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "search":
                searchByName(req, resp);
                break;
            case "rent":
                rent(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:
                showHomepage(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        os.delete(id);
        showHomepage(req, resp);
    }

    private void rent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmtnd = req.getParameter("cmtnd");
        Customer customer = cs.checkCustomer(cmtnd);
        if (customer == null) {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String phone = req.getParameter("phone");
            customer = new Customer(name, age, phone, cmtnd);
            cs.save(customer);
            customer = cs.checkCustomer(cmtnd);
        }
        int id_room = Integer.parseInt(req.getParameter("id"));
        Date date_start = Date.valueOf(req.getParameter("date_start"));
        Date date_end = Date.valueOf(req.getParameter("date_end"));
        Orders orders = new Orders(id_room, customer.getId_customer(), date_start, date_end);
        os.save(orders);
        orders = os.getLastOrder();
        Room room = rs.findById(id_room);
        int diffDay = os.dateDiff(orders.getId_orders());
        orders.setMoney(diffDay * room.getPrice());
        req.setAttribute("customer", customer);
        req.setAttribute("room", room);
        req.setAttribute("orders", orders);
        RequestDispatcher rd = req.getRequestDispatcher("/view/confirm.jsp");
        rd.forward(req, resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("find");
        List<Customer> listC = cs.findByName(name);
        req.setAttribute("list", listC);
        RequestDispatcher rd = req.getRequestDispatcher("/view/customer.jsp");
        rd.forward(req, resp);
    }
}
