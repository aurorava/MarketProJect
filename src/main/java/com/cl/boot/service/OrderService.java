package com.cl.boot.service;

import com.cl.boot.bean.Order;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface OrderService {


    List<Order> findByName(String username);
    List<Order> findLikeName(String goodname);
    List<Order> findAll();
    int getCount();
    List<Order> findLikeuName(String username);
    boolean saveOrder(Order order);
    int likeCount(String username);
}
