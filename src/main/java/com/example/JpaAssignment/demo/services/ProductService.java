package com.example.JpaAssignment.demo.services;

import com.example.JpaAssignment.demo.exceptions.EntityAlreadyExistsException;
import com.example.JpaAssignment.demo.models.Product;
import com.example.JpaAssignment.demo.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Boolean delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new EntityNotFoundException("Given Product Id is not present");
        }
        productRepository.deleteById(id);
        return true;

    }

    public Product update(Product product) {
        Product productToBeUpdated = productRepository.getReferenceById(product.getId());
        productToBeUpdated = product;
        return productRepository.save(product);
    }

}