package com.cl.boot.mapper;

import com.cl.boot.bean.Good;
import com.cl.boot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有
    @Select("select * from userinfo")
    List<User> findAll();

    //插入一条
    @Insert("insert into userinfo(username,password)values(#{username},#{password})")
    boolean saveUser(User user);

    //返回数量
    @Select("select count(*) from userinfo")
    int getCount();

    //根据名字查
    @Select("select * from userinfo where username = #{username}")
    User findByName(String username);

    //根据id删除
    @Delete("delete from userinfo where id = #{id}")
    boolean delUserById(Integer id);

    //模糊查找
    @Select("select * from userinfo where username like '%${value}%'")
    List<User> findLikeName(String username);

    //模糊查找个数
    @Select("select count(*) from userinfo where username like '%${value}%'")
    int likeCount(String username);
    //更新用户
    @Update("update userinfo set username=#{username},password=#{password} where id = #{id}" )
    boolean updateUser(User user);
}
