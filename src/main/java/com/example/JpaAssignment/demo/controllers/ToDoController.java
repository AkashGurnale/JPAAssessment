package com.example.JpaAssignment.demo.controllers;

import com.example.JpaAssignment.demo.beans.ResponseHandler;
import com.example.JpaAssignment.demo.models.Product;
import com.example.JpaAssignment.demo.models.ToDo;
import com.example.JpaAssignment.demo.services.ProductService;
import com.example.JpaAssignment.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/todo")
public class ToDoController {


    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.createResponse("Found tasks", HttpStatus.OK, toDoService.getAll());
    }


    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ToDo task) {
        ToDo newProduct = toDoService.createATask(task);
        return ResponseHandler.createResponse("Created a product successfully", HttpStatus.OK, newProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Boolean isProductDeleted = toDoService.delete(id);
        if (isProductDeleted){
            return ResponseHandler.createResponse("task deleted successfully", HttpStatus.OK, null);
        } else {
            return ResponseHandler.createResponse("Something went wrong", HttpStatus.CONFLICT, null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> delete(@RequestBody ToDo task) {
        ToDo newTask = toDoService.update(task);
        return ResponseHandler.createResponse("Product updated successfully", HttpStatus.OK, newTask);
    }

}
