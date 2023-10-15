package com.database.basics.dao.api;

import com.database.basics.entity.Order;

import java.util.List;

public interface IOrderDAO {


    List<Order> getAllOrders();
}
