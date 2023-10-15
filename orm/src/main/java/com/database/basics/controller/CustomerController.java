package com.database.basics.controller;

import com.database.basics.entity.Customer;
import com.database.basics.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/get")
    public Customer getCustomer(@RequestParam  int customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/save")
    public void save(@RequestBody  Customer customer){
        customerService.save(customer);
    }


    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }
}
