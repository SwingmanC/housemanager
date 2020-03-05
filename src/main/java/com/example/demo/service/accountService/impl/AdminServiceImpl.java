package com.example.demo.service.accountService.impl;

import com.example.demo.dao.AdminInfoMapper;
import com.example.demo.entity.AdminInfo;
import com.example.demo.entity.AdminInfoExample;
import com.example.demo.service.accountService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Override
    public AdminInfo login(AdminInfo adminInfo) {
        AdminInfoExample adminInfoExample = new AdminInfoExample();
        AdminInfoExample.Criteria criteria = adminInfoExample.createCriteria();
        criteria.andTelephoneEqualTo(adminInfo.getTelephone())
                .andPasswordEqualTo(adminInfo.getPassword());

        List<AdminInfo> adminInfoList = adminInfoMapper.selectByExample(adminInfoExample);
        if(!adminInfoList.isEmpty())
        {
            return adminInfoList.get(0);
        }
        return null;
    }

    @Override
    public void updateAdmin(AdminInfo adminInfo) {
        AdminInfoExample adminInfoExample = new AdminInfoExample();
        AdminInfoExample.Criteria criteria = adminInfoExample.createCriteria();
        criteria.andTelephoneEqualTo(adminInfo.getTelephone());
        adminInfoMapper.updateByExample(adminInfo,adminInfoExample);
    }

}
