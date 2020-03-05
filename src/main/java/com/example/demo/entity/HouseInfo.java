package com.example.demo.entity;

import java.util.Date;

public class HouseInfo {
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", houseId=").append(houseId);
        sb.append(", villageId=").append(villageId);
        sb.append(", userId=").append(userId);
        sb.append(", addressId=").append(addressId);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", location=").append(location);
        sb.append(", completeTime=").append(completeTime);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", area=").append(area);
        sb.append(", type=").append(type);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", firstPrice=").append(firstPrice);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", propertyRight=").append(propertyRight);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HouseInfo other = (HouseInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getVillageId() == null ? other.getVillageId() == null : this.getVillageId().equals(other.getVillageId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getAgencyId() == null ? other.getAgencyId() == null : this.getAgencyId().equals(other.getAgencyId()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getCompleteTime() == null ? other.getCompleteTime() == null : this.getCompleteTime().equals(other.getCompleteTime()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUnitPrice() == null ? other.getUnitPrice() == null : this.getUnitPrice().equals(other.getUnitPrice()))
            && (this.getFirstPrice() == null ? other.getFirstPrice() == null : this.getFirstPrice().equals(other.getFirstPrice()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getPropertyRight() == null ? other.getPropertyRight() == null : this.getPropertyRight().equals(other.getPropertyRight()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getVillageId() == null) ? 0 : getVillageId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getAgencyId() == null) ? 0 : getAgencyId().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getCompleteTime() == null) ? 0 : getCompleteTime().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUnitPrice() == null) ? 0 : getUnitPrice().hashCode());
        result = prime * result + ((getFirstPrice() == null) ? 0 : getFirstPrice().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getPropertyRight() == null) ? 0 : getPropertyRight().hashCode());
        return result;
    }
}