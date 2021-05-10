package com.cl.boot.service;

import com.cl.boot.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 登录业务
     * @param user 登录的用户
     * @return 是否成功登录
     */
    boolean userLogin(User user);

    /**
     * 注册业务
     * @param user 注册的用户
     * @return 是否成功
     */
    boolean userRegister(User user);

    /**
     * 获取总条数
     * @return 总条数
     */
    int getCount();

    /**
     * 获取所有用户
     * @return 所有用户
     */
    List<User> findAll();

    /**
     * 注销用户
     * @return
     */
    boolean delUserById(Integer id);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 模糊查找用户
     * @param username
     * @return
     */
    List<User> findLikeName(String username);

    /**
     * 模糊查找条数
     * @param username
     * @return
     */
    int likeCount(String username);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

}
