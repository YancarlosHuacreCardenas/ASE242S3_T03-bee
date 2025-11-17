package pe.edu.vallegrande.demo.repository;

import pe.edu.vallegrande.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByIsActiveTrue();

    List<Customer> findByIsActiveFalse();

    // 🔍 NUEVO: Filtro global con search, type y active
    @Query("""
        SELECT c FROM Customer c
        WHERE 
            (:search IS NULL OR 
                LOWER(c.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR
                LOWER(c.lastName) LIKE LOWER(CONCAT('%', :search, '%')) OR
                LOWER(c.email) LIKE LOWER(CONCAT('%', :search, '%'))
            )
        AND (:type IS NULL OR c.clientType = :type)
        AND (:active IS NULL OR c.isActive = :active)
    """)
    List<Customer> filterCustomers(
            @Param("search") String search,
            @Param("type") String type,
            @Param("active") Boolean active
    );
}
