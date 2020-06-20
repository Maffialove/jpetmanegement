package com.example.jpetmanegement.controller;

import com.example.jpetmanegement.domain.Order;
import com.example.jpetmanegement.service.CatalogService;
import com.example.jpetmanegement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/order/")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("viewOrder")
    public String viewOrder(Model model) {
        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("orderList", orderList);
        return "order/order";
    }
}
