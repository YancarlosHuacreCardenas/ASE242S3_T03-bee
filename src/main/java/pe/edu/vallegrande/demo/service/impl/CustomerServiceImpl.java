package pe.edu.vallegrande.demo.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demo.model.Customer;
import pe.edu.vallegrande.demo.repository.CustomerRepository;
import pe.edu.vallegrande.demo.service.CustomerService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Customer> listarTodos() {
        return repo.findAll();
    }

    @Override
    public List<Customer> listarActivos() {
        return repo.findByIsActiveTrue();
    }

    @Override
    public List<Customer> listarInactivos() {
        return repo.findByIsActiveFalse();
    }

    @Override
    public Customer buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Customer crear(Customer customer) {
        customer.setRegisteredAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setIsActive(true);
        return repo.save(customer);
    }

    @Override
    public Customer editar(Integer id, Customer customer) {
        Customer existente = buscarPorId(id);
        if (existente != null) {
            existente.setFirstName(customer.getFirstName());
            existente.setLastName(customer.getLastName());
            existente.setPhone(customer.getPhone());
            existente.setEmail(customer.getEmail());
            existente.setPreferences(customer.getPreferences());
            existente.setClientType(customer.getClientType());
            existente.setUpdatedAt(LocalDateTime.now());

            // ✅ CORRECCIÓN IMPORTANTE:
            existente.setIsActive(customer.getIsActive());

            return repo.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        Customer customer = buscarPorId(id);
        if (customer != null) {
            customer.setIsActive(false);
            customer.setUpdatedAt(LocalDateTime.now());
            repo.save(customer);
        }
    }

    @Override
    public void restaurar(Integer id) {
        Customer customer = buscarPorId(id);
        if (customer != null) {
            customer.setIsActive(true);
            customer.setUpdatedAt(LocalDateTime.now());
            repo.save(customer);
        }
    }
}
