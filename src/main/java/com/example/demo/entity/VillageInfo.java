package com.example.demo.entity;

public class VillageInfo {
    private Integer id;

    private String villageId;

    private String support;

    private String apartment;

    private String futurePlan;

    private Integer averagePrice;

    private String address;

    private Integer greenRate;

    private Integer volumeRate;

    private Integer parkingLot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getFuturePlan() {
        return futurePlan;
    }

    public void setFuturePlan(String futurePlan) {
        this.futurePlan = futurePlan;
    }

    public Integer getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Integer averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGreenRate() {
        return greenRate;
    }

    public void setGreenRate(Integer greenRate) {
        this.greenRate = greenRate;
    }

    public Integer getVolumeRate() {
        return volumeRate;
    }

    public void setVolumeRate(Integer volumeRate) {
        this.volumeRate = volumeRate;
    }

    public Integer getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Integer parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", villageId=").append(villageId);
        sb.append(", support=").append(support);
        sb.append(", apartment=").append(apartment);
        sb.append(", futurePlan=").append(futurePlan);
        sb.append(", averagePrice=").append(averagePrice);
        sb.append(", address=").append(address);
        sb.append(", greenRate=").append(greenRate);
        sb.append(", volumeRate=").append(volumeRate);
        sb.append(", parkingLot=").append(parkingLot);
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
        VillageInfo other = (VillageInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVillageId() == null ? other.getVillageId() == null : this.getVillageId().equals(other.getVillageId()))
            && (this.getSupport() == null ? other.getSupport() == null : this.getSupport().equals(other.getSupport()))
            && (this.getApartment() == null ? other.getApartment() == null : this.getApartment().equals(other.getApartment()))
            && (this.getFuturePlan() == null ? other.getFuturePlan() == null : this.getFuturePlan().equals(other.getFuturePlan()))
            && (this.getAveragePrice() == null ? other.getAveragePrice() == null : this.getAveragePrice().equals(other.getAveragePrice()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getGreenRate() == null ? other.getGreenRate() == null : this.getGreenRate().equals(other.getGreenRate()))
            && (this.getVolumeRate() == null ? other.getVolumeRate() == null : this.getVolumeRate().equals(other.getVolumeRate()))
            && (this.getParkingLot() == null ? other.getParkingLot() == null : this.getParkingLot().equals(other.getParkingLot()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVillageId() == null) ? 0 : getVillageId().hashCode());
        result = prime * result + ((getSupport() == null) ? 0 : getSupport().hashCode());
        result = prime * result + ((getApartment() == null) ? 0 : getApartment().hashCode());
        result = prime * result + ((getFuturePlan() == null) ? 0 : getFuturePlan().hashCode());
        result = prime * result + ((getAveragePrice() == null) ? 0 : getAveragePrice().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getGreenRate() == null) ? 0 : getGreenRate().hashCode());
        result = prime * result + ((getVolumeRate() == null) ? 0 : getVolumeRate().hashCode());
        result = prime * result + ((getParkingLot() == null) ? 0 : getParkingLot().hashCode());
        return result;
    }
}