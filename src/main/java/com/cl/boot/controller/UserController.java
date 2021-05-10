package com.cl.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.cl.boot.bean.User;
import com.cl.boot.bean.page;
import com.cl.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录业务
     * @param jsonParam 获取参数
     * @return 返回用户名和成功/失败信息
     */
    @ResponseBody
    @RequestMapping("/login")
    public Map login(@RequestBody JSONObject jsonParam,
                     HttpServletResponse response) {
        System.out.println(jsonParam.toJSONString());
        String username = jsonParam.getString("username");
        String password = jsonParam.getString("password");

        Map<String,Object> map = new HashMap<>();
        User user = new User(username, password);

//        Object obj = JSONArray.toJSON(user);
//        String userJson = obj.toString();
        if("root".equals(username) && "root".equals(password)) {
            map.put("username",username);
            map.put("loginMsg","ok");
            map.put("rootUser","yes");
            return map;
        }
        if(userService.userLogin(user)) {
            System.out.println("登录成功");
            map.put("username",username);

            map.put("loginMsg","ok");
            map.put("rootUser","no");
        }else {
            map.put("loginMsg","no");
            map.put("rootUser","no");
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        return map;
    }


    /**
     * 注册业务
     * @param jsonParam 获取参数
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Map register(@RequestBody JSONObject jsonParam,
                        HttpServletResponse response) {

        String username = jsonParam.getString("username");
        String password = jsonParam.getString("password");
        Map<String,Object> map = new HashMap<>();
        User user = new User(username, password);

        boolean b = userService.userRegister(user);
        if(b) {
            System.out.println("注册成功！");
            map.put("registerInfo","ok");
        }else {
            System.out.println("注册失败！");
            map.put("registerInfo","no");
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        return map;
    }

    /**
     * 翻页
     * @param page
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping("/userinfo/{size}/{page}")
    public page userInfoPage(@PathVariable("page")Integer page,
                             @PathVariable("size")Integer size,
                             HttpServletResponse response) {
        page p = null;
        List<User> users = userService.findAll();
        List<User> currentUserList = new ArrayList<>();
        int total = userService.getCount();
        System.out.println("总记录数:"+total);

        p = new page(total,size,page);
        if(total%size != 0 && page == total/size+1) {
            for (int i = users.size()-(total%size); i < users.size(); i++) {
                currentUserList.add(users.get(i));
            }
        }else {
            for (int i = page*size-size; i < page*size; i++) {
                currentUserList.add(users.get(i));
            }
        }
        p.setSList(currentUserList);
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("第"+page+"页，传输的用户表"+currentUserList);
        return p;
    }


    /**
     * 用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delUser/{id}")
    public String delUser(@PathVariable("id")Integer id,
                          HttpServletResponse response) {

        System.out.println("请求删除！！！！");
        userService.delUserById(id);
        return "ok";
    }

    @RequestMapping(value = "/userFindLike")
    public page findLike(HttpServletResponse response)  {
        System.out.println("搜索框没有内容-----");
        page p = null;
        List<User> users = userService.findAll();
        List<User> currentUserList = new ArrayList<>();
        int total = userService.getCount();

        p = new page(total,10,1);

        for (int i = 0; i < 10; i++) {
            currentUserList.add(users.get(i));
        }
        p.setSList(currentUserList);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return p;
    }



    @RequestMapping(value = "/userFindLike/{username}")
    public page findLike(@PathVariable("username")String username,
                         HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        int total = userService.likeCount(username);

        List<User> likeUsers = userService.findLikeName(username);


        page p = new page(total,10,1);
        p.setSList(likeUsers);
        response.setHeader("Access-Control-Allow-Origin", "*");

        return p;
    }

    @GetMapping(value = "/updateUser/{id}/{username}/{password}")
    public String updateUser(@PathVariable("id")Integer id,
                             @PathVariable("username")String username,
                             @PathVariable("password")String password,
                             HttpServletResponse response){

        System.out.println("修改后的用户"+new User(id,username,password));
        userService.updateUser(new User(id,username,password));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "ok";
    }



}
