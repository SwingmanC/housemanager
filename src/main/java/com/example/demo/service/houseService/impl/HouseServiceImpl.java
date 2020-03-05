package com.example.demo.service.houseService.impl;


import com.example.demo.dao.HouseInfoMapper;
import com.example.demo.dao.HousePictureMapper;
import com.example.demo.dao.HouseStateMapper;
import com.example.demo.entity.*;
import com.example.demo.service.houseService.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.config.Constants;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseInfoMapper houseInfoMapper;

    @Autowired
    private HousePictureMapper housePictureMapper;

    @Autowired
    private HouseStateMapper houseStateMapper;

    @Override
    public void addHouse(HouseInfo houseInfo) {
        houseInfoMapper.insert(houseInfo);
    }

    @Override
    public void updateHouse(HouseInfo houseInfo) {
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        HouseInfoExample.Criteria criteria = houseInfoExample.createCriteria();
        criteria.andHouseIdEqualTo(houseInfo.getHouseId());
        houseInfoMapper.updateByExample(houseInfo,houseInfoExample);
    }

    @Override
    public Boolean deleteHouse(String houseId) {
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        HouseInfoExample.Criteria criteria = houseInfoExample.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        houseInfoMapper.deleteByExample(houseInfoExample);
        return true;
    }

    @Override
    public HouseInfo getHouseByHouseId(String houseId) {
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        HouseInfoExample.Criteria criteria = houseInfoExample.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        List<HouseInfo> houseInfoList = houseInfoMapper.selectByExample(houseInfoExample);
        if(!houseInfoList.isEmpty()){
            return houseInfoList.get(0);
        }
        return null;
    }

    @Override
    public List<HouseInfo> getHousesByAddressId(String addressId) {
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        HouseInfoExample.Criteria criteria = houseInfoExample.createCriteria();
        criteria.andAddressIdEqualTo(addressId);
        List<HouseInfo> houseInfoList = houseInfoMapper.selectByExample(houseInfoExample);
        return houseInfoList;
    }

    @Override
    public List<HouseInfo> getHouses() {
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        List<HouseInfo> houseInfoList = houseInfoMapper.selectByExample(houseInfoExample);
        return houseInfoList;
    }

    @Override
    public List<HousePicture> getPicturesByHouseId(String houseId) {
        HousePictureExample housePictureExample = new HousePictureExample();
        HousePictureExample.Criteria criteria = housePictureExample.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        List<HousePicture> housePictureList = housePictureMapper.selectByExample(housePictureExample);
        return housePictureList;
    }

    @Override
    public List<HouseInfo> getHouseByAgencyId(String agencyId) {
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        HouseInfoExample.Criteria criteria = houseInfoExample.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);
        List<HouseInfo> houseInfoList = houseInfoMapper.selectByExample(houseInfoExample);
        return houseInfoList;
    }

    @Override
    public HouseState getStateByHouseId(String houseId) {
        HouseStateExample houseStateExample = new HouseStateExample();
        HouseStateExample.Criteria criteria = houseStateExample.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        List<HouseState> houseStateList = houseStateMapper.selectByExample(houseStateExample);

        return houseStateList.get(0);
    }

    @Override
    public void updateState(HouseState houseState) {
        HouseStateExample houseStateExample = new HouseStateExample();
        HouseStateExample.Criteria criteria = houseStateExample.createCriteria();
        criteria.andHouseIdEqualTo(houseState.getHouseId());
        houseStateMapper.updateByExample(houseState,houseStateExample);
    }

    @Override
    public void addPicture(HousePicture housePicture) {
        housePictureMapper.insert(housePicture);
    }

    @Override
    public Boolean deletePicture(String pictureId) {

        HousePictureExample housePictureExample = new HousePictureExample();
        HousePictureExample.Criteria criteria = housePictureExample.createCriteria();
        criteria.andPictureIdEqualTo(pictureId);
        housePictureMapper.deleteByExample(housePictureExample);
        return true;
    }

    @Override
    public Boolean deletePicturesByHouseId(String houseId) {
        HousePictureExample housePictureExample = new HousePictureExample();
        HousePictureExample.Criteria criteria = housePictureExample.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        housePictureMapper.deleteByExample(housePictureExample);
        return true;
    }

    @Override
    public void addState(HouseState houseState) {
        houseStateMapper.insert(houseState);
    }

    @Override
    public List<HouseInfo> getHouseByTeam(String addressId,String area,String total_price){
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        HouseInfoExample.Criteria criteria = houseInfoExample.createCriteria();
        int are_int = Integer.parseInt(area);
        int total_price_int = Integer.parseInt(total_price);
        criteria.andAddressIdEqualTo(addressId)
                .andAreaLessThanOrEqualTo(are_int)
                .andTotalPriceLessThanOrEqualTo(total_price_int);
        List<HouseInfo> houseInfoList = houseInfoMapper.selectByExample(houseInfoExample);
        HouseStateExample houseStateExample = new HouseStateExample();
        HouseStateExample.Criteria criteria1 = houseStateExample.createCriteria();
        for(int i = 0 ;i < houseInfoList.size();i++){
            criteria1.andHouseIdEqualTo(houseInfoList.get(i).getHouseId());
            List<HouseState> houseStateList = houseStateMapper.selectByExample(houseStateExample);
            if(houseStateList.get(0).getState().equals(Constants.HouseState.NOT_PASS)){
                houseInfoList.remove(i);
            }
        }
        return houseInfoList;

    }

    @Override
    public List<HousePicture> getFirstPictureByHouseList(List<HouseInfo> houseInfoList){
        HousePictureExample housePictureExample = new HousePictureExample();
        HousePictureExample.Criteria criteria = housePictureExample.createCriteria();
        List<HousePicture> housePictureList = housePictureMapper.selectByExample(housePictureExample);
        List<HousePicture> housePictureList_1;
        for(int i =0;i<houseInfoList.size();i++){
            criteria.andHouseIdEqualTo(houseInfoList.get(i).getHouseId());
            housePictureList_1 = housePictureMapper.selectByExample(housePictureExample);
            if(!housePictureList_1.isEmpty()){
                housePictureList.add(housePictureList_1.get(0));
            }else {
                housePictureList.add(null);
            }
        }
        return housePictureList;
    }

    @Override
    public List<HouseInfo> getHouseInfoListByUserId(String userId){
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        HouseInfoExample.Criteria criteria = houseInfoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<HouseInfo> houseInfoList = houseInfoMapper.selectByExample(houseInfoExample);
        return houseInfoList;
    }

    @Override
    public List<HouseInfo> getHouseByCondition(List<AddressInfo> addressInfoList,String min_area,String max_area,String min_price,String max_price,String min_c_time,String max_c_time){
        HouseInfoExample houseInfoExample=new HouseInfoExample();
        HouseInfoExample.Criteria criteria=houseInfoExample.createCriteria();
        int min_area_int = Integer.parseInt(min_area);
        int max_area_int = Integer.parseInt(max_area);
        int min_price_int = Integer.parseInt(min_price);
        int max_price_int = Integer.parseInt(max_price);
        min_c_time+="-01-01 00:00:00";
        max_c_time+="-01-01 00:00:00";
        Date min_date=new Date();
        Date max_date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition position=new ParsePosition(8);
        min_date=format.parse(min_c_time,position);
        max_date=format.parse(max_c_time,position);

        List<HouseInfo> houseInfoList = new ArrayList<>();
        for(AddressInfo addressInfo:addressInfoList){
            criteria.andAddressIdEqualTo(addressInfo.getAddressId())
                    .andAreaBetween(min_area_int,max_area_int)
                    .andUnitPriceBetween(min_price_int,max_price_int);
            List<HouseInfo> temp = houseInfoMapper.selectByExample(houseInfoExample);
            houseInfoList.addAll(temp);
        }

        return houseInfoList;
    }

}
