package com.cl.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.cl.boot.bean.Good;
import com.cl.boot.bean.User;
import com.cl.boot.bean.page;
import com.cl.boot.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/goodinfo/{size}/{page}")
    public page goodsinfo(@PathVariable("page")Integer page,
                          @PathVariable("size")Integer size) {

        page p = null;
        List<Good> Goods = goodService.findAll();
        List<Good> currentUserList = new ArrayList<>();
        int total = goodService.getCount();
        System.out.println("总记录数:"+total);

        p = new page(total,size,page);
        if(total%size != 0 && page == total/size+1) {
            for (int i = Goods.size()-(total%size); i < Goods.size(); i++) {
                currentUserList.add(Goods.get(i));
            }
        }else {
            for (int i = page*size-size; i < page*size; i++) {
                currentUserList.add(Goods.get(i));
            }
        }

        p.setSList(currentUserList);
        System.out.println("第"+page+"页，传输的物品表"+currentUserList);
        return p;

    }


    @RequestMapping(value = "/delGood/{id}")
    public String delUser(@PathVariable("id")Integer id){
        goodService.delGoodById(id);
        System.out.println("删除了"+id+"物品");
        return "ok";
    }


    @RequestMapping(value = "/goodFindLike")
    public page findLike(HttpServletResponse response)  {
        System.out.println("搜索框没有内容-----");
        page p = null;
        List<Good> goods = goodService.findAll();
        List<Good> currentGoodList = new ArrayList<>();
        int total = goodService.getCount();

        p = new page(total,10,1);

        for (int i = 0; i < 10; i++) {
            currentGoodList.add(goods.get(i));
        }
        p.setSList(currentGoodList);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return p;
    }

    @RequestMapping(value = "/goodFindLike/{gName}")
    public page findLike(@PathVariable("gName")String gName,
                         HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        int total = goodService.getLikeCount(gName);

        List<Good> likeGoods = goodService.findLikeName(gName);


        page p = new page(total,10,1);
        p.setSList(likeGoods);
        response.setHeader("Access-Control-Allow-Origin", "*");

        return p;
    }

    @RequestMapping("/changeState/{id}")
    public String changeState(@PathVariable("id") Integer id,HttpServletResponse response) {

        if(goodService.changeState(id)) {
            System.out.println("改变了"+id+"的状态");
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "ok";
    }

    @RequestMapping("/addGood")
    public String addGood(@RequestBody JSONObject jsonParam) {
        String gName = jsonParam.getString("gName");
        String gCount = jsonParam.getString("gCount");
        String gPrice = jsonParam.getString("gPrice");

        System.out.println("待添加的商品"+gName+":"+gCount+":"+gPrice);
        Good newGood = new Good(gName, Integer.parseInt(gCount), Integer.parseInt(gPrice), true, 0);

        goodService.saveGood(newGood);
        return "ok";

    }

    @RequestMapping("/updateGood")
    public String updateGood(@RequestBody JSONObject jsonParam) {
        String gName = jsonParam.getString("gName");
        String gCount = jsonParam.getString("gCount");
        String gPrice = jsonParam.getString("gPrice");
        String id = jsonParam.getString("id");
        System.out.println("待修改的商品"+gName+":"+gCount+":"+gPrice);
        Good newGood = new Good(Integer.parseInt(id),gName, Integer.parseInt(gCount), Integer.parseInt(gPrice), true, 0);

        goodService.updateGood(newGood);
        return "ok";

    }

    @RequestMapping(value = "/clientGoods")
    public List<Good> clientGood() {
        List<Good> goodsList = goodService.findAll();
        List<Good> curList = new ArrayList<>();
        int total = goodService.getCount();
        if(total <= 30) {
            for (int i = 0; i < total; i++) {
                curList.add(goodsList.get(i));
            }
            return curList;
        }
        for (int i = 0; i < 30; i++) {
            curList.add(goodsList.get(i));
        }
        return curList;
    }

    @RequestMapping(value = "/clientGoodInfo/{id}")
    public Good clientGoodInfo(@PathVariable("id")Integer id) {
        Good curGood = goodService.findById(id);

        if(curGood == null) {
            return new Good("00000");
        }
        System.out.println("根据id="+id+"查询到:"+curGood);
        return curGood;
    }

    @RequestMapping(value = "/updateGoodsCount/{id}/{newCount}")
    public String updateCount(@PathVariable("id")Integer id,
                              @PathVariable("newCount")Integer newCount){
        if(newCount == 0){
            System.out.println("库存为0删除"+id);
            goodService.delGoodById(id);
            return "delok";
        }
        goodService.updateGoodCount(newCount, id);
        System.out.println("更新了"+id+"的库存:"+newCount);
        return "ok";
    }


    @RequestMapping(value = "/searchGoods/{msg}")
    public List<Good> searchGoods(@PathVariable("msg")String msg){
        List<Good> curGoodsList = goodService.findLikeName(msg);

        if(curGoodsList == null) {
            System.out.println("没有搜到");
            return null;
        }

        return curGoodsList;

    }
}
