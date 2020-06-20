package com.example.jpetmanegement.persistence;

import com.example.jpetmanegement.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> getOrderList();

    void insertOrder(Order order);

    Order getOrder(int orderId);

    void insertOrderStatus(Order order);
}
