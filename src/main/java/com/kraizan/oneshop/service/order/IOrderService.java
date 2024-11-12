package com.kraizan.oneshop.service.order;

import java.util.List;

import com.kraizan.oneshop.dto.OrderDto;
import com.kraizan.oneshop.model.Order;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
}