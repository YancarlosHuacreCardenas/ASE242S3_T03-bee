package pe.edu.vallegrande.demo.repository;

import pe.edu.vallegrande.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByIsActiveTrue();
    List<Customer> findByIsActiveFalse();
}
