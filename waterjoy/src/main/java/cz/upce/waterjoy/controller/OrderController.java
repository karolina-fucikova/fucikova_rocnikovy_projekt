package cz.upce.waterjoy.controller;

import cz.upce.waterjoy.model.Orders;
import cz.upce.waterjoy.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST: vytvoří novou objednávku
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    // GET: všechny objednávky
    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
