package com.example.demo.service.addressService;

import com.example.demo.entity.AddressInfo;

import java.util.List;

public interface AddressService {

    AddressInfo getAddressByExample(AddressInfo addressInfo);

    List<AddressInfo> getAddressByProvince(AddressInfo addressInfo);

    List<AddressInfo> getAddressByCity(AddressInfo addressInfo);

    List<AddressInfo> getAllAddress(AddressInfo addressInfo);

    List<AddressInfo> getAddressByRegion(AddressInfo addressInfo);

    AddressInfo getAddressByAddressId(String addressId);

}
