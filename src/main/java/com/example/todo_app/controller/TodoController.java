package com.example.todo_app.controller;

import com.example.todo_app.model.TodoItem;
import com.example.todo_app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<TodoItem> getTodoById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoService.save(todoItem);
    }

    @PutMapping(path = "/{id}")
    public TodoItem updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItem) {
        todoItem.setId(id);
        return todoService.save(todoItem);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTodoItem(@PathVariable Long id) {
        todoService.deleteById(id);
    }

}
