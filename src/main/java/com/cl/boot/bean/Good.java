package com.cl.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Good {

    private Integer id;
    private String gName;
    private Integer gCount;
    private double gPrice;
    private boolean state;
    private Integer sales;

    public Good(String gname, Integer gcount, double gprice, boolean state, Integer sales) {
        this.gName = gname;
        this.gCount = gcount;
        this.gPrice = gprice;
        this.state = state;
        this.sales = sales;
    }
    public Good(String name){
        this.gName = name;
    }
}
