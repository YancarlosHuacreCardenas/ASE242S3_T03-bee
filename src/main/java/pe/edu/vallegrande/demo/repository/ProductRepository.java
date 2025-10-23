package pe.edu.vallegrande.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.demo.model.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByIsAvailableTrue();

    List<Product> findByIsAvailableFalse();
}
