package com.example.demo.service.addressService.impl;

import com.example.demo.dao.AddressInfoMapper;
import com.example.demo.entity.AddressInfo;
import com.example.demo.entity.AddressInfoExample;
import com.example.demo.service.addressService.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressInfoMapper addressInfoMapper;

    @Override
    public AddressInfo getAddressByExample(AddressInfo addressInfo){
        AddressInfoExample addressInfoExample = new AddressInfoExample();
        AddressInfoExample.Criteria criteria = addressInfoExample.createCriteria();

//        if (addressInfo.getProvince()!=null)
//            criteria.andProvinceEqualTo(addressInfo.getProvince());

        criteria.andCityEqualTo(addressInfo.getCity())
                .andRegionEqualTo(addressInfo.getRegion());
        List<AddressInfo> addressInfoList = addressInfoMapper.selectByExample(addressInfoExample);
        if (!addressInfoList.isEmpty())
        {
            return addressInfoList.get(0);
        }
        return null;
    }

    @Override
    public List<AddressInfo> getAddressByProvince(AddressInfo addressInfo) {

        AddressInfoExample addressInfoExample = new AddressInfoExample();
        AddressInfoExample.Criteria criteria = addressInfoExample.createCriteria();
        criteria.andProvinceEqualTo(addressInfo.getProvince());

        return addressInfoMapper.selectByExample(addressInfoExample);
    }

    @Override
    public List<AddressInfo> getAddressByCity(AddressInfo addressInfo) {

        AddressInfoExample addressInfoExample = new AddressInfoExample();
        AddressInfoExample.Criteria criteria = addressInfoExample.createCriteria();
        criteria.andCityEqualTo(addressInfo.getCity());

        return addressInfoMapper.selectByExample(addressInfoExample);
    }

    @Override
    public List<AddressInfo> getAllAddress(AddressInfo addressInfo){

        AddressInfoExample addressInfoExample = new AddressInfoExample();
        AddressInfoExample.Criteria criteria = addressInfoExample.createCriteria();
        criteria.andAddressIdIsNotNull();
        return addressInfoMapper.selectByExample(addressInfoExample);

    }

    @Override
    public  List<AddressInfo> getAddressByRegion(AddressInfo addressInfo){

        AddressInfoExample addressInfoExample = new AddressInfoExample();
        AddressInfoExample.Criteria criteria=addressInfoExample.createCriteria();
        criteria.andProvinceEqualTo(addressInfo.getProvince())
                .andCityEqualTo(addressInfo.getCity())
                .andRegionEqualTo(addressInfo.getRegion());
        return addressInfoMapper.selectByExample(addressInfoExample);
    }

    @Override
    public AddressInfo getAddressByAddressId(String addressId) {

        AddressInfoExample addressInfoExample = new AddressInfoExample();
        AddressInfoExample.Criteria criteria = addressInfoExample.createCriteria();
        criteria.andAddressIdEqualTo(addressId);

        return addressInfoMapper.selectByExample(addressInfoExample).get(0);
    }
}
