package com.example.demo.vo;

import com.example.demo.entity.HouseInfo;
import com.example.demo.entity.HousePicture;
import com.example.demo.entity.UserInfo;

public class Order {
    private String location;

    private HousePicture housePicture;

    private UserInfo userInfo;

    private int price;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public HousePicture getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(HousePicture housePicture) {
        this.housePicture = housePicture;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
