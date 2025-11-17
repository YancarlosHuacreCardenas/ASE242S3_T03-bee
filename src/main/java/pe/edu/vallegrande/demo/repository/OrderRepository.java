package pe.edu.vallegrande.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
