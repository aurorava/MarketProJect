package com.cl.boot.service;

import com.cl.boot.bean.Good;
import com.cl.boot.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodService {

    /**
     * 查询所有物品信息
     * @return 物品集合
     */
    List<Good> findAll();

    /**
     * 查询总物品数
     * @return
     */
    int getCount();

    /**
     * 添加商品
     * @param good
     * @return
     */
    boolean saveGood(Good good);

    /**
     * 根据物品id删除
     * @param id
     * @return
     */
    boolean delGoodById(Integer id);

    /**
     * 更新物品信息
     * @param good
     * @return
     */
    boolean updateGood(Good good);


    List<Good> findLikeName(String gName);


    int getLikeCount(String gName);

    /**
     * 改变上架状态
     * @param id
     * @return
     */
    boolean changeState(Integer id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Good findById(Integer id);

    /**
     * 更新库存
     * @param newcount
     * @param id
     * @return
     */
    boolean updateGoodCount(Integer newcount , Integer id);
}
