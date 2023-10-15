package com.database.basics.dao.api;

import com.database.basics.entity.Customer;

import java.util.List;

public interface ICustomerDAO {

    void save(Customer customer);

    Customer get(int customerId);

    List<Customer> getAllCustomers();

}
