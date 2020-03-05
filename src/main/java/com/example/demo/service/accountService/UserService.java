package com.example.demo.service.accountService;

import com.example.demo.entity.UserInfo;

public interface UserService {

    UserInfo login(UserInfo userInfo);

    void addUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    Boolean deleteUser(String userId);

    UserInfo getUserByUserId(String userId);

    UserInfo getUserByTelephone(String telephone);
}
