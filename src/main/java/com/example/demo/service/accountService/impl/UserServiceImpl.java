package com.example.demo.service.accountService.impl;

import com.example.demo.dao.UserInfoMapper;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserInfoExample;
import com.example.demo.service.accountService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(UserInfo userInfo) {

        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andTelephoneEqualTo(userInfo.getTelephone())
                .andPasswordEqualTo(userInfo.getPassword());

        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        if(!userInfoList.isEmpty()){
            return userInfoList.get(0);
        }

        return null;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andTelephoneEqualTo(userInfo.getTelephone());
        userInfoMapper.updateByExample(userInfo,userInfoExample);
    }

    @Override
    public Boolean deleteUser(String userId) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        userInfoMapper.deleteByExample(userInfoExample);
        return true;
    }
    @Override
    public UserInfo getUserByUserId(String userId){
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        if(!userInfoList.isEmpty())
        {
            return userInfoList.get(0);
        }
        return null;
    }

    @Override
    public UserInfo getUserByTelephone(String telephone) {

        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andTelephoneEqualTo(telephone);

        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        if(!userInfoList.isEmpty())
        {
            return userInfoList.get(0);
        }
        return null;
    }
}
