package com.example.demo.service.orderService.impl;

import com.example.demo.dao.OrderInfoMapper;
import com.example.demo.entity.OrderInfo;
import com.example.demo.entity.OrderInfoExample;
import com.example.demo.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public void addOrder(OrderInfo orderInfo) {
        orderInfoMapper.insert(orderInfo);
    }

    @Override
    public List<OrderInfo> getOrders() {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);
        return orderInfoList;
    }

    @Override
    public OrderInfo getOrderByOrderId(String orderId) {

        OrderInfoExample orderInfoExample = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);

        if(!orderInfoList.isEmpty()){
            return orderInfoList.get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public List<OrderInfo> getOrdersByUserId(String userId) {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);
        return orderInfoList;
    }

    @Override
    public List<OrderInfo> getOrdersByAgencyId(String agencyId) {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);
        return orderInfoList;
    }


}
