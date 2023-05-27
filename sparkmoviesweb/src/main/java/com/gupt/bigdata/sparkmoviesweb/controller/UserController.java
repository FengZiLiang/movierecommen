package com.gupt.bigdata.sparkmoviesweb.controller;

import com.gupt.bigdata.sparkmoviesweb.entity.User;
import com.gupt.bigdata.sparkmoviesweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/ListUser")
    @ResponseBody
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(int userid){
        return userService.getUserById(userid);
    }

    @RequestMapping(value="/getUserByName",method = RequestMethod.GET)
    public List<User> getUsersByName(String username){
        return userService.getUsersByName(username);
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public String insertUser(@RequestBody User user) {
        String username = HtmlUtils.htmlEscape(user.getUsername());
        user.setUsername(username);
        String password = HtmlUtils.htmlEscape(user.getPassword());
        user.setPassword(password);
        int result=userService.insertUser(user);
        if (result >= 1) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
    public String deleteUserById(int userid) {
        int result = userService.deleteUserById(userid);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePasswordById(User user) {
        int result = userService.updatePasswordById(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public User loginUser(@RequestBody User user) {
        String username = HtmlUtils.htmlEscape(user.getUsername());
        user.setUsername(username);
        String password = HtmlUtils.htmlEscape(user.getPassword());
        user.setPassword(password);
        System.out.println(username+","+password+","+userService.loginUser(user).getUsername());
        return userService.loginUser(user);
    }

}
