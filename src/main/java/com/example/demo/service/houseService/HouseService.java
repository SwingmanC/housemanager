package com.example.demo.service.houseService;

import com.example.demo.entity.AddressInfo;
import com.example.demo.entity.HouseInfo;
import com.example.demo.entity.HousePicture;
import com.example.demo.entity.HouseState;

import java.util.List;

public interface HouseService {

    void addHouse(HouseInfo houseInfo);

    void updateHouse(HouseInfo houseInfo);

    Boolean deleteHouse(String houseId);

    HouseInfo getHouseByHouseId(String houseId);

    List<HouseInfo> getHousesByAddressId(String addressId);

    List<HouseInfo> getHouses();

    List<HousePicture> getPicturesByHouseId(String houseId);

    List<HouseInfo> getHouseByAgencyId(String agencyId);

    void addPicture(HousePicture housePicture);

    Boolean deletePicture(String pictureId);

    Boolean deletePicturesByHouseId(String houseId);

    HouseState getStateByHouseId(String houseId);

    void updateState(HouseState houseState);

    void addState(HouseState houseState);

    List<HouseInfo> getHouseByTeam(String addreassId,String area,String total_price);

    List<HousePicture> getFirstPictureByHouseList(List<HouseInfo> houseInfoList);

    List<HouseInfo> getHouseInfoListByUserId(String userId);

    List<HouseInfo> getHouseByCondition(List<AddressInfo> addressInfoList, String min_area, String max_area, String min_price, String max_price, String min_c_time, String max_c_time);
}
