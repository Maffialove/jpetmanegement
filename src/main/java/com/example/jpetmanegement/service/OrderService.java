package com.example.jpetmanegement.service;

import com.example.jpetmanegement.domain.Order;
import com.example.jpetmanegement.persistence.ItemMapper;
import com.example.jpetmanegement.persistence.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrderList() {
        return orderMapper.getOrderList();
    }
//    @Transactional
//    public void insertOrder(Order order) {
//        order.setOrderId(getNextId("ordernum"));
//
//        //更改库存数量
//        for (int i = 0; i < order.getLineItems().size(); i++) {
//            LineItem lineItem = (LineItem) order.getLineItems().get(i);
//            String itemId = lineItem.getItemId();
//            Integer increment = lineItem.getQuantity();
//            Map<String, Object> param = new HashMap<String, Object>(2);
//            param.put("itemId", itemId);
//            param.put("increment", increment);
//            itemMapper.updateInventoryQuantity(param);
//        }
//
//        orderMapper.insertOrder(order);
//        orderMapper.insertOrderStatus(order);
//        for (int i = 0; i < order.getLineItems().size(); i++) {
//            LineItem lineItem = (LineItem) order.getLineItems().get(i);
//            lineItem.setOrderId(order.getOrderId());
//            lineItemMapper.insertLineItem(lineItem);
//        }
//    }
//
//    @Transactional
//    public Order getOrder(int orderId) {
//        Order order = orderMapper.getOrder(orderId);
//        order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
//
//        for (int i = 0; i < order.getLineItems().size(); i++) {
//            LineItem lineItem = (LineItem) order.getLineItems().get(i);
//            Item item = itemMapper.getItem(lineItem.getItemId());
//            item.setQuantity(itemMapper.getInventoryQuantity(lineItem.getItemId()));
//            lineItem.setItem(item);
//        }
//
//        return order;
//    }
//
//    public List<Order> getOrderListByUsername(String username) {
//        return orderMapper.getOrderListByUsername(username);
//    }
//
//    public int getNextId(String name) {
//        Sequence sequence = new Sequence(name, -1);
//        sequence = (Sequence) sequenceMapper.getSequence(sequence);
//        if (sequence == null) {
//            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
//                    + " sequence).");
//        }
//        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
//        sequenceMapper.updateSequence(parameterObject);
//        return sequence.getNextId();
//    }

}
