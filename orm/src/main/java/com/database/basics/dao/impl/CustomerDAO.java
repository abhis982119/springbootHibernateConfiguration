package com.database.basics.dao.impl;

import com.database.basics.dao.api.ICustomerDAO;
import com.database.basics.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAO implements ICustomerDAO {
    @Autowired
    private EntityManager factory;

    private Session getCurrentSession() {
        return factory.unwrap(Session.class);
    }


    @Override
    public void save(Customer customer) {
        getCurrentSession().persist(customer);
    }

    @Override
    public Customer get(int customerId) {
        Criteria criteria = getCurrentSession().createCriteria(Customer.class);
        criteria
                .add(Restrictions.eq("id", customerId));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        Object o = criteria.uniqueResult();
        if (o != null) {
            return ((Customer) o);
        }
        return null;
    }


    public List<Customer> getAllCustomers(){
        Criteria criteria = getCurrentSession().createCriteria(Customer.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List list = criteria.list();
        if (list != null) {
            List<Customer> result =  ((List<Customer>) list);
            System.out.println("result " + result);
            System.out.println("result.size() " + result.size());
        }
        return null;
    }
}
