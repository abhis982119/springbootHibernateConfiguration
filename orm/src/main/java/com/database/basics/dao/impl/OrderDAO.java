package com.database.basics.dao.impl;

import com.database.basics.dao.api.IOrderDAO;
import com.database.basics.entity.Customer;
import com.database.basics.entity.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderDAO implements IOrderDAO {


    @Autowired
    private EntityManager factory;

    private Session getCurrentSession() {
        return factory.unwrap(Session.class);
    }



    @Override
    public List<Order> getAllOrders() {
        Criteria criteria = getCurrentSession().createCriteria(Order.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List list = criteria.list();
        if (list != null) {
            List<Order> result =  ((List<Order>) list);
            System.out.println("result " + result);
            System.out.println("result.size() " + result.size());
            return result;
        }
        return null;
    }
}
