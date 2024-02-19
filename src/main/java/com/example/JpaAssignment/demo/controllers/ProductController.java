package com.example.JpaAssignment.demo.controllers;

import com.example.JpaAssignment.demo.beans.ResponseHandler;
import com.example.JpaAssignment.demo.models.Product;
import com.example.JpaAssignment.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v2/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.createResponse("Found products", HttpStatus.OK, productService.getAll());
    }


    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Product product) {
        Product newProduct = productService.create(product);
        return ResponseHandler.createResponse("Created a product successfully", HttpStatus.OK, newProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Boolean isProductDeleted = productService.delete(id);
        if (isProductDeleted){
            return ResponseHandler.createResponse("product deleted successfully", HttpStatus.OK, null);
        } else {
            return ResponseHandler.createResponse("Something went wrong", HttpStatus.CONFLICT, null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> delete(@RequestBody Product product) {
        Product newProduct = productService.update(product);
        return ResponseHandler.createResponse("Product updated successfully", HttpStatus.OK, product);
    }

}
