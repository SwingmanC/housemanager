package com.example.demo.controller;

import com.example.demo.config.Constants;
import com.example.demo.entity.*;
import com.example.demo.service.accountService.UserService;
import com.example.demo.service.agencyService.AgencyService;
import com.example.demo.service.houseService.HouseService;
import com.example.demo.service.orderService.OrderService;
import com.example.demo.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private HttpSession session;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    @RequestMapping("/addOrder")
    public String addOrder(@RequestParam(value = "houseId") String houseId,
                           @RequestParam(value = "agencyId") String agencyId,
                           Model model){
        OrderInfo orderInfo= new OrderInfo();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        String orderId = RandomUtil.productId();
        orderInfo.setOrderId(orderId);
        orderInfo.setUserId(userInfo.getUserId());
        orderInfo.setHouseId(houseId);
        orderInfo.setAgencyId(agencyId);
        orderInfo.setCreateTime(new Date());
        orderInfo.setPrice(5);
        orderService.addOrder(orderInfo);
        orderInfo = orderService.getOrderByOrderId(orderId);
        AgencyInfo agencyInfo = agencyService.getAgencyInfoByAgencyId(orderInfo.getAgencyId());
        HouseInfo houseInfo = houseService.getHouseByHouseId(orderInfo.getHouseId());

        HouseState houseState = houseService.getStateByHouseId(houseInfo.getHouseId());
        houseState.setState(Constants.HouseState.BOUGHT);
        houseService.updateState(houseState);

        model.addAttribute("userInfo",userInfo);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("agencyInfo",agencyInfo);
        model.addAttribute("houseInfo",houseInfo);
        return "order/order_detail";
    }

    @RequestMapping("/getOrderList")
    public String getOrderList(Model model){
        List<OrderInfo> orderInfoList = orderService.getOrders();
        model.addAttribute("orderInfoList",orderInfoList);
        return "order/order_list";
    }

    @RequestMapping("/getOrderByOrderId")
    public String getOrderByOrderId(@RequestParam(value = "orderId") String orderId,Model model){
        OrderInfo orderInfo = orderService.getOrderByOrderId(orderId);
        String agencyId=orderInfo.getAgencyId();
        String houseId=orderInfo.getHouseId();
        String userId=orderInfo.getUserId();
        HouseInfo houseInfo=houseService.getHouseByHouseId(houseId);
        UserInfo userInfo=userService.getUserByUserId(userId);
        AgencyInfo agencyInfo=agencyService.getAgencyInfoByAgencyId(agencyId);
        model.addAttribute("agencyInfo",agencyInfo);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("houseInfo",houseInfo);
        return "order/order_detail";
    }

    @RequestMapping("/getOrdersByUserId")
    public String getOrdersByUserId(@RequestParam(value = "userId") String userId,Model model){
        List<OrderInfo> orderInfoList=orderService.getOrdersByUserId(userId);
        model.addAttribute("orderInfoList",orderInfoList);
        return "order/order_list";
    }

    @RequestMapping("/getOrdersByAgencyId")
    public String getOrdersByAgencyId(@RequestParam(value = "agencyId") String agencyId,Model model){
        List<OrderInfo> orderInfoList=orderService.getOrdersByAgencyId(agencyId);
        model.addAttribute("orderInfoList",orderInfoList);
        return "agency_order";
    }
}
