package com.cl.boot.service.impl;

import com.cl.boot.bean.User;
import com.cl.boot.mapper.UserMapper;
import com.cl.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;





    @Override
    public boolean userLogin(User user) {
        User queryUser = userMapper.findByName(user.getUsername());
        if(queryUser != null && (user.getPassword()==queryUser.getPassword())) {
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean userRegister(User user) {
        User queryUser = userMapper.findByName(user.getUsername());
        if(queryUser == null) {
            userMapper.saveUser(user);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public boolean delUserById(Integer id) {
        return userMapper.delUserById(id);
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public List<User> findLikeName(String username) {
        return userMapper.findLikeName(username);
    }

    @Override
    public int likeCount(String username) {
        return userMapper.likeCount(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
