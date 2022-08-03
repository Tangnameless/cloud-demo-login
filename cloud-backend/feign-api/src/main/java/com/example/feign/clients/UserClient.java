package com.example.feign.clients;

import com.example.feign.common.R;
import com.example.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-service")
public interface UserClient {
    @GetMapping("/user/{id}")
    R<User> findById(@PathVariable("id") Long id);

    @GetMapping("/user/query_name")
    R<User> queryByUsername(@RequestParam("username") String username);

    @PostMapping("/user")
    R<String> save(@RequestBody User user);

}
