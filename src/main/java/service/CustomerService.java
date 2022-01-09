package service;

import dao.CustomerDao;
import model.Customer;

import java.util.List;

public class CustomerService {
    private static final CustomerDao cd = new CustomerDao();

    public List<Customer> findAll(){
        return cd.findAll();
    }

    public void save(Customer customer){
        cd.save(customer);
    }

    public void edit(Customer customer){
        cd.edit(customer);
    }

    public void delete(int id){
        cd.delete(id);
    }

    public List<Customer> findByName(String name){ return cd.findByName(name);}

    public Customer checkCustomer(String cmtnd){ return cd.checkCustomer(cmtnd);}

    public List<Customer> findAllBookedCustomer() {
        return cd.findAllBookedCustomer();
    }

    public Customer getCustomerById(int id_customer) {
        return cd.findCustomerById(id_customer);
    }
}
