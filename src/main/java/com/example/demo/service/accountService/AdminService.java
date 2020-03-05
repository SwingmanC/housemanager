package com.example.demo.service.accountService;

import com.example.demo.entity.AdminInfo;

public interface AdminService {

    AdminInfo login(AdminInfo adminInfo);

    void updateAdmin(AdminInfo adminInfo);

}