package com.cl.boot.mapper;

import com.cl.boot.bean.Good;
import com.cl.boot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface GoodMapper {

    @Select("select * from goodinfo")
    List<Good> findAll();

    @Select("select count(*) from goodinfo")
    int getCount();

    @Insert("insert into goodinfo(gName,gCount,gPrice,state,sales)values(#{gName},#{gCount},#{gPrice},#{state},#{sales})")
    boolean saveGood(Good good);

    @Delete("delete from goodinfo where id = #{id}")
    boolean delGoodById(Integer id);

    @Update("update goodinfo set gName=#{gName},gCount=#{gCount},gPrice=#{gPrice} where id = #{id}" )
    boolean updateGood(Good good);

    //更新库存
    @Update("update goodinfo set gCount=#{newcount} where id = ${id}")
    boolean updateGoodCount(Integer newcount , Integer id);



    //模糊查找
    @Select("select * from goodinfo where gName like '%${value}%'")
    List<Good> findLikeName(String gName);

    //模糊查找个数
    @Select("select count(*) from goodinfo where gName like '%${value}%'")
    int likeCount(String gName);

    //改变上架状态
    @Update("update goodinfo set state=not state where id=#{id}")
    boolean changeState(Integer id);

    @Select("select * from goodinfo where id = #{id}")
    Good findById(Integer id);
}
