package com.monkey1024.controller;

import com.alibaba.fastjson.JSON;
import com.monkey1024.bean.User;
import com.monkey1024.util.DataUtil;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;


@RestController
public class UserRestController {


    /**
     * Find all users
     * @return
     * @throws Exception
     */
    @GetMapping("/users")
    public String findAll() throws Exception{

        HashMap<String, User> allUser = DataUtil.findAll();

        //Return json format
        return JSON.toJSONString(allUser);
    }


    /**
     * Find by id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/users/{id}")
    public String findById(@PathVariable String id) throws Exception{
        User user = DataUtil.findUserById(id);

        return JSON.toJSONString(user);
    }


    /**
     * Add new user
     * @param user
     * @return
     */
    @PostMapping("/users")
    //@RequestMapping(value = "/users",method = RequestMethod.POST)
    public String create(@RequestBody User user) {
        try {
            DataUtil.create(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }


    /**
     * Update
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/users/{id}")
    public String update(@PathVariable String id,@RequestBody User user){
        try {
            DataUtil.update(id,user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    /**
     * Delete user
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable String id){
        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }
}
