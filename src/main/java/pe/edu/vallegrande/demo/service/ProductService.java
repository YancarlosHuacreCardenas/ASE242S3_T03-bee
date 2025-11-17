package pe.edu.vallegrande.demo.service;

import pe.edu.vallegrande.demo.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> listarTodos();
    List<Product> listarActivos();
    List<Product> listarInactivos();
    Product buscarPorId(Integer id);
    Product crear(Product product);
    Product editar(Integer id, Product product);
    void eliminar(Integer id);
    void restaurar(Integer id);
}
