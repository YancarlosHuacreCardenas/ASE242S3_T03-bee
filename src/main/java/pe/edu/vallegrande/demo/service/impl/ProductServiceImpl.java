package pe.edu.vallegrande.demo.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demo.model.Product;
import pe.edu.vallegrande.demo.repository.ProductRepository;
import pe.edu.vallegrande.demo.service.ProductService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> listarTodos() {
        return repo.findAll();
    }

    @Override
    public List<Product> listarActivos() {
        return repo.findByIsAvailableTrue();
    }

    @Override
    public List<Product> listarInactivos() {
        return repo.findByIsAvailableFalse();
    }

    @Override
    public Product buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Product crear(Product product) {
        product.setIsAvailable(true);
        product.setIsFeatured(false);
        return repo.save(product);
    }

    @Override
    public Product editar(Integer id, Product product) {
        Product existente = buscarPorId(id);
        if (existente != null) {
            existente.setName(product.getName());
            existente.setDescription(product.getDescription());
            existente.setPrice(product.getPrice());
            existente.setCategory(product.getCategory());
            existente.setIsAvailable(product.getIsAvailable());
            existente.setImageUrl(product.getImageUrl());
            existente.setLaunchDate(product.getLaunchDate());
            existente.setPrepTime(product.getPrepTime());
            existente.setIsFeatured(product.getIsFeatured());
            existente.setNutritionalInfo(product.getNutritionalInfo());
            return repo.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        Product product = buscarPorId(id);
        if (product != null) {
            product.setIsAvailable(false);
            repo.save(product);
        }
    }

    @Override
    public void restaurar(Integer id) {
        Product product = buscarPorId(id);
        if (product != null) {
            product.setIsAvailable(true);
            repo.save(product);
        }
    }
}
