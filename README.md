# cloud-demo-login
中行实习小demo





## 整体结构设计

### 表结构

| 字段     | 数据类型 | 备注         |
| -------- | -------- | ------------ |
| id       | bigint   | 自增id       |
| username | varchar  | 用户名，唯一 |
| password | varchar  | 密码         |





### 代码结构

后端部分的结构设计

```
cloud-backend
    - user-service  # 对user表的CURD
    - auth-service  # 模拟登录，远程调用userservice接口
    - feign-api     # feign相关代码封装
    - gateway       # 网关微服务
```

前端：vue

数据库：本地mysql数据库（临时）



### 主要思路

- 登录/注册服务和用户服务都对外暴露 Restful 的接口
- 登录/注册服务如果需要查询用户信息，只能调用用户服务的 Restful 接口，不能查询用户数据库





![image-20220804091334328](README.assets/image-20220804091334328.png)

蓝色为已完成模块





## 接口设计

接口文档详见：https://console-docs.apipost.cn/preview/5e57a19e88b1b9ec/d6fbaae0feb11505





## TO-DO

- [ ] 学习 Docker，微服务的部署部分
- [ ] 基于 token 实现”真正“的登入和登出
