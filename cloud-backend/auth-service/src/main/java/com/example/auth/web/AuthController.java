package com.example.auth.web;


import com.example.feign.common.R;
import com.example.feign.pojo.User;
import com.example.feign.clients.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;

import java.util.Map;


@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    // restTemplate 方式远程调用
    // 举例：在auth-service中 向user-service发起一个http的请求，调用http://localhost:8081/user/{userId}这个接口。
    // 与实际登录注册功能无关
    @GetMapping("/{userId}")
    public void queryUserByUserId(@PathVariable("userId") String userId) {
        // 远程查询user
        String url = "http://localhost:8081/user/" + userId;
        // 发起调用
        String result = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject data = JSON.parseObject(jsonObject.getString("data"));
        if (data == null) {
            System.out.println("无此用户");
        } else {
            String username = data.getString("username");
            String password = data.getString("password");
            System.out.println("用户存在！");
            System.out.println("用户名： " + username + " 密码： " + password);
        }
    }

    // feign 方式远程调用
    @GetMapping("/feign/{userId}")
    public void queryfeign(@PathVariable("userId") Long userId) {
        R<User> result = userClient.findById(userId);
        if (result.getData() == null) {
            System.out.println("无此用户");
        } else {
            String username = result.getData().getUsername();
            String password = result.getData().getPassword();
            System.out.println("用户存在！");
            System.out.println("用户名： " + username + " 密码： " + password);
        }
    }

    // 前端项目所需的接口
    // 1. 登录接口： POST /auth/login
    @PostMapping("/login")
    public R<String> login(@RequestBody Map<String, String> params) {
        String username = params.get("loginName");
        String password = params.get("password");
        R<User> result = userClient.queryByUsername(username);
        if (result.getData() != null) {
            String password_db = result.getData().getPassword();
            if (password.equals(password_db)) {
                return R.success("登录成功！");
            }
        }
        return R.error("登陆失败！");
    }

    // 2. 注册接口： POST /auth/register
    @PostMapping("/register")
    public R<String> register(@RequestBody Map<String, String> params) {
        String username = params.get("loginName");
        String password = params.get("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        R<String> result = userClient.save(user);
        return result;
    }

}
