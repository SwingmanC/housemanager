package com.example.demo.service.orderService;

import com.example.demo.entity.OrderInfo;

import java.util.List;

public interface OrderService {

    void addOrder(OrderInfo orderInfo);

    List<OrderInfo> getOrders();

    OrderInfo getOrderByOrderId(String orderId);

    List<OrderInfo> getOrdersByUserId(String userId);

    List<OrderInfo> getOrdersByAgencyId(String agencyId);
}
