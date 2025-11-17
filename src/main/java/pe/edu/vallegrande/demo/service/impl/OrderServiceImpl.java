package pe.edu.vallegrande.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.demo.model.Order;
import pe.edu.vallegrande.demo.model.OrderDetail;
import pe.edu.vallegrande.demo.repository.OrderRepository;
import pe.edu.vallegrande.demo.repository.OrderDetailRepository;
import pe.edu.vallegrande.demo.service.OrderService;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepo;
    private final OrderDetailRepository detailRepo;

    public OrderServiceImpl(OrderRepository orderRepo, OrderDetailRepository detailRepo) {
        this.orderRepo = orderRepo;
        this.detailRepo = detailRepo;
    }

    @Transactional
    @Override
    public Order createOrderWithDetails(Order order) {
        Order savedOrder = orderRepo.save(order);

        if (order.getDetails() != null) {
            BigDecimal total = BigDecimal.ZERO;
            for (OrderDetail detail : order.getDetails()) {
                detail.setOrder(savedOrder);
                detailRepo.save(detail);
                total = total.add(detail.getPriceAtPurchase().multiply(BigDecimal.valueOf(detail.getQuantity())));
            }
            savedOrder.setTotalAmount(total);
            orderRepo.save(savedOrder);
        }

        return savedOrder;
    }

    @Override
    public List<Order> listAllOrders() {
        return orderRepo.findAll();
    }
}
