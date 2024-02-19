package com.example.JpaAssignment.demo.services;

import com.example.JpaAssignment.demo.models.Product;
import com.example.JpaAssignment.demo.models.ToDo;
import com.example.JpaAssignment.demo.repositories.ToDoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAll() { return toDoRepository.findAll();}

    public ToDo createATask(ToDo task){
        return toDoRepository.save(task);
    }

    public Boolean delete(Long id) {
        Optional<ToDo> taskOptional = toDoRepository.findById(id);
        if (taskOptional.isEmpty()) {
            throw new EntityNotFoundException("Given task Id is not present");
        }
        toDoRepository.deleteById(id);
        return true;

    }

    public ToDo update(ToDo task) {
        ToDo taskToBeUpdated = toDoRepository.getReferenceById(task.getId());
        taskToBeUpdated = task;
        return toDoRepository.save(task);
    }
}
