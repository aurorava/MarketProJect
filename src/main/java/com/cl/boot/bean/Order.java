package com.cl.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer id;
    private String username;
    private String goodname;
    private Integer count;
    private Double gprice;
    private Double tprice;
    private String date;

    public Order(String username, String goodname, Integer count, Double gprice, Double tprice, String date) {
        this.username = username;
        this.goodname = goodname;
        this.count = count;
        this.gprice = gprice;
        this.tprice = tprice;
        this.date = date;
    }
}
