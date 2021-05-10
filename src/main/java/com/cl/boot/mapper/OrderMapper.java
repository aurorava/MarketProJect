package com.cl.boot.mapper;

import com.cl.boot.bean.Order;
import com.cl.boot.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from userorder")
    List<Order> findAll();

    @Select("select count(*) from userorder")
    int getCount();

    @Select("select * from userorder where username = #{username}")
    List<Order> findByName(String username);

    @Insert("insert into userorder(username,goodname,count,gprice,tprice,date)values(#{username},#{goodname},#{count},#{gprice},#{tprice},#{date})")
    boolean saveOrder(Order order);

    @Select("select * from userorder where goodname like '%${value}%'")
    List<Order> findLikeName(String goodname);
    @Select("select * from userorder where username like '%${value}%'")
    List<Order> findLikeuName(String username);

    @Select("select count(*) from userorder where username like '%${value}%'")
    int likeCount(String username);


}
