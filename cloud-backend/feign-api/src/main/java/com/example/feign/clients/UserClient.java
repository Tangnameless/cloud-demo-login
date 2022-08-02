package com.example.feign.clients;

import com.example.feign.common.R;
import com.example.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/user/{id}")
    R<User> findById(@PathVariable("id") Long id);
}
