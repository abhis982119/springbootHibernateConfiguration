package com.database.basics.service;

import com.database.basics.dao.api.IOrderDAO;
import com.database.basics.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    private IOrderDAO orderDAO;


    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }

}
