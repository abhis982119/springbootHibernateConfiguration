package com.database.basics.service;

import com.database.basics.dao.api.ICustomerDAO;
import com.database.basics.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = false, transactionManager = "platformTransactionManager")
public class CustomerService {

    @Autowired
    private ICustomerDAO customerDAO;

    public Customer getCustomer(int customerId){
        return customerDAO.get(customerId);
    }

    public void save(Customer customer){
        customerDAO.save(customer);
    }


    public List<Customer> getAllCustomers(){
       return  customerDAO.getAllCustomers();
    }



}
