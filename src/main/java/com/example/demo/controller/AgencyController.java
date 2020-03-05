package com.example.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.demo.config.Constants;
import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import com.example.demo.entity.*;
import com.example.demo.service.accountService.UserService;
import com.example.demo.service.addressService.AddressService;
import com.example.demo.service.agencyService.AgencyService;
import com.example.demo.service.houseService.HouseService;
import com.example.demo.service.orderService.OrderService;
import com.example.demo.service.otherService.MessageCodeService;
import com.example.demo.utils.RandomUtil;
import com.example.demo.vo.Agency;
import com.example.demo.vo.House;
import com.example.demo.vo.Order;
//import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private HttpSession session;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping("/addAgency")
    public String addAgency(@RequestParam(value = "name") String name,
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phone") String telephone,
                            @RequestParam(value = "province") String province,
                            @RequestParam(value = "city") String city,
                            @RequestParam(value = "region") String region,
                            @RequestParam(value = "location") String location) {

        AddressInfo bbb = new AddressInfo();
        bbb.setCity(city);

        if (province!=null)
            bbb.setProvince(province);

        bbb.setRegion(region);
        AddressInfo addressInfo = addressService.getAddressByExample(bbb);
        AgencyInfo agencyInfo = new AgencyInfo();

        agencyInfo.setAgencyId(RandomUtil.productId());
        agencyInfo.setEmail(email);
        agencyInfo.setTelephone(telephone);
        agencyInfo.setName(name);
        agencyInfo.setLocation(location);
        agencyInfo.setAddressId(addressInfo.getAddressId());

        AgencyState agencyState = new AgencyState();
        agencyState.setAgencyId(agencyInfo.getAgencyId());
        agencyState.setStateId(RandomUtil.productId());
        agencyState.setState(Constants.AgencyState.NOT_PASS);

        agencyService.addAgency(agencyInfo);
        agencyService.addState(agencyState);
        return "agency/agency_sign_in";
    }

    @RequestMapping("/deleteAgency")
    public String deleteAgency(@RequestParam(value = "agencyId") String agencyId) {
        agencyService.deleteAgencyState(agencyId);
        agencyService.deleteAgency(agencyId);
        return "";
    }

    @RequestMapping("/changeAgency")
    public String changeAgency(@RequestParam(value = "agencyId") String agencyId,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "location") String location,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "telephone") String telephone) {

        AgencyInfo agencyInfo = agencyService.getAgencyInfoByAgencyId(agencyId);
        AgencyState agencyState = agencyService.getStateByAgencyId(agencyId);
        agencyInfo.setName(name);
        agencyInfo.setLocation(location);
        agencyInfo.setEmail(email);
        agencyInfo.setTelephone(telephone);

        agencyState.setState(Constants.AgencyState.NOT_PASS);

        agencyService.updateAgency(agencyInfo);
        agencyService.updateState(agencyState);
        return "";
    }

    @ResponseBody
    @RequestMapping("/updateState")//管理员审核中介公司信息
    public Result setAgencyState(@RequestParam(value = "agencyId") String agencyId) {
        AgencyState agencyState = agencyService.getStateByAgencyId(agencyId);
        agencyState.setState(Constants.AgencyState.PASS);
        agencyService.updateState(agencyState);
        return ResultGenerator.success("审核成功");
    }

    @RequestMapping("/getAgencyInfo")//中介公司登录
    public String getAgencyInfo(@RequestParam(value = "agencyId") String agencyId, Model model) {
        AgencyInfo agencyInfo = agencyService.getAgencyInfoByAgencyId(agencyId);
        AgencyState agencyState = agencyService.getStateByAgencyId(agencyId);
        AddressInfo addressInfo = addressService.getAddressByAddressId(agencyInfo.getAddressId());

        model.addAttribute("addressInfo",addressInfo);
        model.addAttribute("agencyInfo",agencyInfo);
        model.addAttribute("agencyState",agencyState);

        session.setAttribute("agencyInfo",agencyInfo);
        session.setAttribute("agencyState",agencyState);

        session.removeAttribute("adminInfo");
        session.removeAttribute("userInfo");

        return "agency/agency_info";
    }

    @RequestMapping("/getAgency")//管理员查询中介公司信息页
    public String getAgency(@RequestParam(value = "agencyId") String agencyId,
                            Model model)
    {
        AgencyInfo agencyInfo = agencyService.getAgencyInfoByAgencyId(agencyId);
        AgencyState agencyState = agencyService.getStateByAgencyId(agencyId);
        AddressInfo addressInfo = addressService.getAddressByAddressId(agencyInfo.getAddressId());

        model.addAttribute("addressInfo",addressInfo);
        model.addAttribute("agencyInfo",agencyInfo);
        model.addAttribute("agencyState",agencyState);

        return "agency/agency_info";
    }

    @RequestMapping("/getHouses")
    public String getHouses(Model model)
    {
        AgencyInfo agencyInfo = (AgencyInfo) session.getAttribute("agencyInfo");
        List<HouseInfo> houseInfoList = houseService.getHouseByAgencyId(agencyInfo.getAgencyId());
        List<House> houseList = new ArrayList<>();

        for(int i=0;i<houseInfoList.size();i++)
        {
            House house = new House();
            house.setAddressId(houseInfoList.get(i).getAddressId());
            house.setAgencyId(houseInfoList.get(i).getAgencyId());
            house.setArea(houseInfoList.get(i).getArea());
            house.setCompleteTime(houseInfoList.get(i).getCompleteTime());
            house.setFirstPrice(houseInfoList.get(i).getFirstPrice());
            house.setHouseId(houseInfoList.get(i).getHouseId());
            house.setLocation(houseInfoList.get(i).getLocation());
            house.setPropertyRight(houseInfoList.get(i).getPropertyRight());
            house.setReleaseTime(houseInfoList.get(i).getReleaseTime());
            house.setType(houseInfoList.get(i).getType());
            house.setTotalPrice(houseInfoList.get(i).getTotalPrice());
            house.setUnitPrice(houseInfoList.get(i).getUnitPrice());
            house.setVillageId(houseInfoList.get(i).getVillageId());
            house.setUserId(houseInfoList.get(i).getUserId());
            house.setHousePictures(houseService.getPicturesByHouseId(houseInfoList.get(i).getHouseId()));
            houseList.add(house);
        }

        model.addAttribute("houseList",houseList);

        return "agency/agency_house";
    }

    @RequestMapping("/viewLogin")
    public String viewLogin()
    {
        return "agency/agency_sign_in";
    }

    @RequestMapping("/viewRegister")
    public String viewRegister()
    {
        return "agency/agency_sign_up";
    }

    @RequestMapping("/getOrders")
    public String getOrders(Model model){
        AgencyInfo agencyInfo = (AgencyInfo) session.getAttribute("agencyInfo");
        List<OrderInfo> orderInfoList = orderService.getOrdersByAgencyId(agencyInfo.getAgencyId());
        List<Order> orderList = new ArrayList<>();

        for(int i=0;i<orderInfoList.size();i++){
            Order order = new Order();
            order.setPrice(orderInfoList.get(i).getPrice());
            order.setHousePicture(houseService.getPicturesByHouseId(orderInfoList.get(i).getHouseId()).get(0));
            order.setLocation(houseService.getHouseByHouseId(orderInfoList.get(i).getHouseId()).getLocation());
            order.setUserInfo(userService.getUserByUserId(orderInfoList.get(i).getUserId()));
            orderList.add(order);
        }
        model.addAttribute("orderList",orderList);
        return "agency/agency_order";
    }
    @RequestMapping("/getAllAgency")
    public String getAllAgency(Model model) {
        AgencyInfo agencyInfo = (AgencyInfo) session.getAttribute("agencyInfo");
        List<AgencyInfo> agencyInfoList = agencyService.getAgencies();
        System.out.println(agencyInfoList.size());
        List<Agency> agencyList = new ArrayList<>();
        for(int i=0;i<agencyInfoList.size();i++){
            Agency agency = new Agency();
            agency.setName(agencyInfoList.get(i).getName());
            agency.setAgencyId(agencyInfoList.get(i).getAgencyId());

            AgencyState agencyState = agencyService.getStateByAgencyId(agencyInfoList.get(i).getAgencyId());
            agency.setState(agencyState.getState());

            List<HouseInfo> houseInfoList = houseService.getHouseByAgencyId(agencyInfoList.get(i).getAgencyId());
            System.out.println(houseInfoList.size());
            double flag=0;
            for(int j = 0;j<houseInfoList.size();j++){
                flag = flag+houseInfoList.get(j).getTotalPrice();
            }
            if(houseInfoList.size()==0){
                agency.setAveragePrice(0);
            }
            else{
                flag = flag/houseInfoList.size();
                agency.setAveragePrice(flag);
            }
            agency.setNumberOfHouses(houseInfoList.size());
            agencyList.add(agency);
        }
        model.addAttribute("agencyList", agencyList);
        return "agency/agency_list";
    }

    @ResponseBody
    @RequestMapping("/getAgencyListByAddress")
    public Result getAgencyListByAddress(@RequestParam(value = "province",required = false) String province,
                                         @RequestParam(value = "city") String city,
                                         @RequestParam(value = "region") String region)
    {
        AddressInfo addressInfo = new AddressInfo();
        if (province!=null)
            addressInfo.setProvince(province);
        addressInfo.setCity(city);
        addressInfo.setRegion(region);

        addressInfo = addressService.getAddressByExample(addressInfo);
        //System.out.print(addressInfo);
        List<AgencyInfo> agencyInfoList = agencyService.getAgencyInfoByAddressId(addressInfo.getAddressId());
        return ResultGenerator.success(agencyInfoList);
    }


    @RequestMapping("/exit")
    public String exit()
    {
        session.removeAttribute("agencyInfo");
        session.removeAttribute("agencyState");
        return "account/sign_in";
    }
}
