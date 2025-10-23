package pe.edu.vallegrande.demo.rest;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demo.model.Customer;
import pe.edu.vallegrande.demo.service.CustomerService;

/**
 * Controlador REST para gestionar clientes.
 * Los endpoints están protegidos por configuración global de CORS en WebConfig.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerRest {

    private final CustomerService service;

    public CustomerRest(CustomerService service) {
        this.service = service;
    }

    // ✅ Listar todos los clientes (activos e inactivos)
    @GetMapping
    public List<Customer> listarTodos() {
        return service.listarTodos();
    }

    // ✅ Listar clientes activos
    @GetMapping("/activos")
    public List<Customer> listarActivos() {
        return service.listarActivos();
    }

    // ✅ Listar clientes inactivos
    @GetMapping("/inactivos")
    public List<Customer> listarInactivos() {
        return service.listarInactivos();
    }

    // ✅ Buscar cliente por ID
    @GetMapping("/{id}")
    public Customer buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // ✅ Crear cliente nuevo
    @PostMapping
    public Customer crear(@RequestBody Customer customer) {
        return service.crear(customer);
    }

    // ✅ Actualizar cliente existente
    @PutMapping("/{id}")
    public Customer editar(@PathVariable Integer id, @RequestBody Customer customer) {
        return service.editar(id, customer);
    }

    // ✅ Desactivar cliente (eliminación lógica)
    @PatchMapping("/{id}/eliminar")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    // ✅ Restaurar cliente eliminado
    @PatchMapping("/{id}/restaurar")
    public void restaurar(@PathVariable Integer id) {
        service.restaurar(id);
    }
}
