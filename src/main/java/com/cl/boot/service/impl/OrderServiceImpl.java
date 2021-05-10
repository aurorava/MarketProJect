package com.cl.boot.service.impl;

import com.cl.boot.bean.Order;
import com.cl.boot.mapper.OrderMapper;
import com.cl.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<Order> findByName(String username) {
        return orderMapper.findByName(username);
    }

    @Override
    public List<Order> findLikeName(String goodname) {
        return orderMapper.findLikeName(goodname);
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public int getCount() {
        return orderMapper.getCount();
    }

    @Override
    public List<Order> findLikeuName(String username) {
        return orderMapper.findLikeuName(username);
    }

    @Override
    public boolean saveOrder(Order order) {
        return orderMapper.saveOrder(order);
    }

    @Override
    public int likeCount(String username) {
        return orderMapper.likeCount(username);
    }
}
