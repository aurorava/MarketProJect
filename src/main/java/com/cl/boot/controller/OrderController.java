package com.cl.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.cl.boot.bean.Order;
import com.cl.boot.bean.User;
import com.cl.boot.bean.page;
import com.cl.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 生成订单
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/saveOrder")
    public String saveOrder(@RequestBody JSONObject jsonParam){


        System.out.println(jsonParam.toJSONString());
        String username = jsonParam.getString("username");
        String goodname = jsonParam.getString("goodname");
        String gprice = jsonParam.getString("gprice");
        String count = jsonParam.getString("count");
        String tprice = jsonParam.getString("tprice");
        String date = jsonParam.getString("date");


        //int y = d.getMonth();
        orderService.saveOrder(new Order(username,goodname,Integer.parseInt(count),Double.parseDouble(gprice),Double.parseDouble(tprice),date));
        return "okk";
    }

    /**
     * 用户订单
     * @param usrname
     * @return
     */
    @RequestMapping(value = "/userOrder/{username}")
    public List<Order> userOrder(@PathVariable("username")String usrname){
        List<Order> orders = orderService.findByName(usrname);

        return orders;

    }

    /**
     * 订单模糊查询
     * @param usrname
     * @param msg
     * @return
     */
    @RequestMapping(value = "/userLikeOrder/{username}/{msg}")
    public List<Order> userLikeOrder(@PathVariable("username")String usrname,
                                     @PathVariable("msg")String msg){
        List<Order> orders = orderService.findLikeName(msg);

        return orders;
    }
    @RequestMapping(value = "/userLikeOrder/{username}")
    public List<Order> userLikeOrder(@PathVariable("username")String username){

        return orderService.findByName(username);
    }

    @RequestMapping(value = "/allOrder/{size}/{page}")
    public page allOrder(@PathVariable("page")Integer page,
                                @PathVariable("size")Integer size){
        page p = null;
        List<Order> Orders = orderService.findAll();
        List<Order> currentOrderList = new ArrayList<>();
        int total = orderService.getCount();
        System.out.println("总记录数:"+total);

        p = new page(total,size,page);
        if(total%size != 0 && page == total/size+1) {
            for (int i = Orders.size()-(total%size); i < Orders.size(); i++) {
                currentOrderList.add(Orders.get(i));
            }
        }else {
            for (int i = page*size-size; i < page*size; i++) {
                currentOrderList.add(Orders.get(i));
            }
        }
        p.setSList(currentOrderList);
        return p;

    }

    @RequestMapping(value = "/findLikeUsername/{username}")
    public page findLikeUsername(@PathVariable("username")String username){

        page p = null;
        List<Order> Orders = orderService.findLikeuName(username);
        List<Order> currentOrderList = new ArrayList<>();
        int total = orderService.likeCount(username);
        System.out.println("总记录数:"+total);

        p = new page(total,10,1);
        if(total%10 != 0 && 1 == total/10+1) {
            for (int i = Orders.size()-(total%10); i < Orders.size(); i++) {
                currentOrderList.add(Orders.get(i));
            }
        }else {
            for (int i = 1*10-10; i < 1*10; i++) {
                currentOrderList.add(Orders.get(i));
            }
        }
        p.setSList(currentOrderList);
        return p;
    }

    @RequestMapping(value = "/findLikeUsername")
    public page findLikeUsername(){

        page p = null;
        List<Order> Orders = orderService.findAll();
        List<Order> currentOrderList = new ArrayList<>();
        int total = orderService.getCount();
        System.out.println("总记录数:"+total);
        p = new page(total,10,1);
        if(total%10 != 0 && 1 == total/10+1) {
            for (int i = Orders.size()-(total%10); i < Orders.size(); i++) {
                currentOrderList.add(Orders.get(i));
            }
        }else {
            for (int i = 1*10-10; i < 1*10; i++) {
                currentOrderList.add(Orders.get(i));
            }
        }
        p.setSList(currentOrderList);
        return p;
    }

    
}
