package org.example.service;

import org.example.dao.OrderDao;
import org.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }

    @Override
    public Order getOrder(int id) {
        return orderDao.findById(id);
    }
} 