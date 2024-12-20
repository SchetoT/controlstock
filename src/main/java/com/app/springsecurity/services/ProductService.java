package com.app.springsecurity.services;

import com.app.springsecurity.entities.Category;
import com.app.springsecurity.entities.Product;
import com.app.springsecurity.repositories.CategoryRepository;
import com.app.springsecurity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired // Inyecta CategoryRepository
    private CategoryRepository categoryRepository;

    //crear y guardar producto
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //Listar todas los productos
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    //obtener product por id
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    //actualizar producto
    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            // Actualiza solo los campos que necesitas actualizar
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());

            if (updatedProduct.getCategory() != null && updatedProduct.getCategory().getId() != null) {
                Optional<Category> categoryOptional = categoryRepository.findById(updatedProduct.getCategory().getId());
                if (categoryOptional.isPresent()) {
                    product.setCategory(categoryOptional.get());
                }
            }

            return productRepository.save(product); // Guarda los cambios
        } else {
            return null; // Devuelve null si no se encuentra el producto
        }
    }

    //eliminar producto
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    public void addCategoryToProduct(Integer productId, Integer categoryId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId); // Usa categoryRepository

        if (productOptional.isPresent() && categoryOptional.isPresent()) {
            Product product = productOptional.get();
            Category category = categoryOptional.get();

            product.setCategory(category);
            productRepository.save(product);
        } else {
            if (!productOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado con ID: " + productId);
            } else { // !categoryOptional.isPresent()
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada con ID: " + categoryId);
            }
        }
    }
}