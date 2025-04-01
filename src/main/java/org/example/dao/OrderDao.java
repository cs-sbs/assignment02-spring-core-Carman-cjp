package org.example.dao;

import org.example.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDao {
    private final Map<Integer, Order> orderDB = new HashMap<>();

    public void save(Order order) {
        orderDB.put(order.getId(), order);
    }

    public Order findById(int id) {
        return orderDB.get(id);
    }
} 