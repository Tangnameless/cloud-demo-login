package com.example.user.web;

import com.example.user.common.R;
import com.example.user.pojo.User;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController { // 提供restful风格的接口

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public R<User> queryById(@PathVariable("id") Long id) {
        User user = userService.queryById(id);
        if(user == null){
            return R.error("用户不存在");
        }else{
            return R.success(user);
        }
    }

    @GetMapping("/list")
    public List<User> queryList() {
        return userService.queryList();
    }

    @PostMapping
    public R<String> save(@RequestBody User user) {
        try{
            userService.save(user);
            return R.success("新增用户成功！");
        } catch (DuplicateKeyException e){
            e.printStackTrace();
            return R.error("新增用户失败！用户名重复");
        }
    }
}

