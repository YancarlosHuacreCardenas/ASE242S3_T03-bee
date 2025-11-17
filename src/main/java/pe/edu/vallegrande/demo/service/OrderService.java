package pe.edu.vallegrande.demo.service;

import pe.edu.vallegrande.demo.model.Order;
import java.util.List;

public interface OrderService {
    Order createOrderWithDetails(Order order);
    List<Order> listAllOrders();
}
