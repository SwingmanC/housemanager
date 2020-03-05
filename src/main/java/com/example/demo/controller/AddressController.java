package com.example.demo.controller;

import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import com.example.demo.entity.AddressInfo;
import com.example.demo.service.addressService.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ResponseBody
    @RequestMapping("/province")
    public Result getAddressByProvince(@RequestParam(value = "province") String province)
    {
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setProvince(province);
        List<AddressInfo> addressInfoList = addressService.getAddressByProvince(addressInfo);
        return ResultGenerator.success(addressInfoList);
    }

    @ResponseBody
    @RequestMapping("/city")
    public Result getAddressByCity(@RequestParam(value = "city") String city)
    {
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setCity(city);
        List<AddressInfo> addressInfoList = addressService.getAddressByCity(addressInfo);
        return ResultGenerator.success(addressInfoList);
    }

}
