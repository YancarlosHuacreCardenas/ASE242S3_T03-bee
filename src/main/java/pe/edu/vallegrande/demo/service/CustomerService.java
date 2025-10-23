package pe.edu.vallegrande.demo.service;

import pe.edu.vallegrande.demo.model.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> listarTodos();
    List<Customer> listarActivos();
    List<Customer> listarInactivos();
    Customer buscarPorId(Integer id);
    Customer crear(Customer customer);
    Customer editar(Integer id, Customer customer);
    void eliminar(Integer id);
    void restaurar(Integer id);
}
