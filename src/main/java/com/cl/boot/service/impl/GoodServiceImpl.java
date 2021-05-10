package com.cl.boot.service.impl;

import com.cl.boot.bean.Good;
import com.cl.boot.mapper.GoodMapper;
import com.cl.boot.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> findAll() {
        return goodMapper.findAll();
    }

    @Override
    public int getCount() {
        return goodMapper.getCount();
    }

    @Override
    public boolean saveGood(Good good) {
        return goodMapper.saveGood(good);
    }

    @Override
    public boolean delGoodById(Integer id) {
        return goodMapper.delGoodById(id);
    }

    @Override
    public boolean updateGood(Good good) {
        return goodMapper.updateGood(good);
    }

    @Override
    public List<Good> findLikeName(String gName) {
        return goodMapper.findLikeName(gName);
    }

    @Override
    public int getLikeCount(String gName) {
        return goodMapper.likeCount(gName);
    }

    @Override
    public boolean changeState(Integer id) {
        return goodMapper.changeState(id);
    }

    @Override
    public Good findById(Integer id) {
        return goodMapper.findById(id);
    }

    @Override
    public boolean updateGoodCount(Integer newcount, Integer id) {
        return goodMapper.updateGoodCount(newcount,id);
    }


}
