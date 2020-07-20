package com.example.smartmart.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public List<Customer> getAllCustomers(){
        return (List<Customer>) repo.findAll();
    }

    public Customer getCustomer(int id){
        return repo.findById(id).orElse(new Customer());
    }

    public void updateCustomer(Customer customer){
        repo.save(customer);
    }

    public void saveCustomer(Customer customer){
        repo.save(customer);
    }

    public void deleteCustomer(int id){
        repo.deleteById(id);
    }

}
