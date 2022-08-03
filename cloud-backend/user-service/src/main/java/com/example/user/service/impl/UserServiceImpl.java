package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.user.mapper.UserMapper;
import com.example.user.pojo.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查一条
     * @param id
     * @return
     */
    public User queryById(Long id) {
        return userMapper.selectById(id);
    }

    /**
     * 查全部
     * @return
     */
    public List<User> queryList() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
        return userList;
    }


}
