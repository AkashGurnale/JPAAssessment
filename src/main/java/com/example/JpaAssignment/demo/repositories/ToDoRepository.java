package com.example.JpaAssignment.demo.repositories;

import com.example.JpaAssignment.demo.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
