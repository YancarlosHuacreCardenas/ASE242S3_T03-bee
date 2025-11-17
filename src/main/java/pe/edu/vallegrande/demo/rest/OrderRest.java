package pe.edu.vallegrande.demo.rest;

import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demo.model.Order;
import pe.edu.vallegrande.demo.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRest {

    private final OrderService service;

    public OrderRest(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrderWithDetails(order);
    }

    @GetMapping
    public List<Order> listOrders() {
        return service.listAllOrders();
    }
}
