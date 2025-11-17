package pe.edu.vallegrande.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demo.model.Customer;
import pe.edu.vallegrande.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRest {

    private final CustomerService service;

    public CustomerRest(CustomerService service) {
        this.service = service;
    }

    // 🔍 GET con filtros opcionales
    @GetMapping
    public List<Customer> listarConFiltros(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Boolean active
    ) {
        return service.buscarConFiltros(search, type, active);
    }

    @GetMapping("/activos")
    public List<Customer> listarActivos() {
        return service.listarActivos();
    }

    @GetMapping("/inactivos")
    public List<Customer> listarInactivos() {
        return service.listarInactivos();
    }

    @GetMapping("/{id}")
    public Customer buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Customer crear(@RequestBody Customer customer) {
        return service.crear(customer);
    }

    @PutMapping("/{id}")
    public Customer editar(@PathVariable Integer id, @RequestBody Customer customer) {
        return service.editar(id, customer);
    }

    @PatchMapping("/{id}/eliminar")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    @PatchMapping("/{id}/restaurar")
    public void restaurar(@PathVariable Integer id) {
        service.restaurar(id);
    }
}
