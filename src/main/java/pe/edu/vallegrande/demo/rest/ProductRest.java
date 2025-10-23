package pe.edu.vallegrande.demo.rest;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demo.model.Product;
import pe.edu.vallegrande.demo.service.ProductService;

/**
 * Controlador REST para gestionar productos.
 * Los endpoints usan la configuración global de CORS definida en WebConfig.
 */
@RestController
@RequestMapping("/api/products")
public class ProductRest {

    private final ProductService service;

    public ProductRest(ProductService service) {
        this.service = service;
    }

    // ✅ Listar todos los productos (activos e inactivos)
    @GetMapping
    public List<Product> listarTodos() {
        return service.listarTodos();
    }

    // ✅ Listar productos activos
    @GetMapping("/activos")
    public List<Product> listarActivos() {
        return service.listarActivos();
    }

    // ✅ Listar productos inactivos
    @GetMapping("/inactivos")
    public List<Product> listarInactivos() {
        return service.listarInactivos();
    }

    // ✅ Buscar producto por ID
    @GetMapping("/{id}")
    public Product buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // ✅ Crear nuevo producto
    @PostMapping
    public Product crear(@RequestBody Product product) {
        return service.crear(product);
    }

    // ✅ Actualizar producto existente
    @PutMapping("/{id}")
    public Product editar(@PathVariable Integer id, @RequestBody Product product) {
        return service.editar(id, product);
    }

    // ✅ Desactivar producto (soft delete)
    @PatchMapping("/{id}/eliminar")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    // ✅ Restaurar producto desactivado
    @PatchMapping("/{id}/restaurar")
    public void restaurar(@PathVariable Integer id) {
        service.restaurar(id);
    }
}
