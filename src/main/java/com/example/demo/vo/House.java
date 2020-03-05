package com.example.demo.vo;

import com.example.demo.entity.HousePicture;

import java.util.Date;
import java.util.List;

public class House {

    private String houseId;

    private String villageId;

    private String userId;

    private String addressId;

    private String agencyId;

    private String location;

    private Date completeTime;

    private Date releaseTime;

    private Integer area;

    private String type;

    private Integer unitPrice;

    private Integer firstPrice;

    private Integer totalPrice;

    private Integer propertyRight;

    private List<HousePicture> housePictures;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(Integer firstPrice) {
        this.firstPrice = firstPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPropertyRight() {
        return propertyRight;
    }

    public void setPropertyRight(Integer propertyRight) {
        this.propertyRight = propertyRight;
    }

    public List<HousePicture> getHousePictures() {
        return housePictures;
    }

    public void setHousePictures(List<HousePicture> housePictures) {
        this.housePictures = housePictures;
    }
}
