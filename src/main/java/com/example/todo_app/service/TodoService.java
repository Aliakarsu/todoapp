package com.example.todo_app.service;

import com.example.todo_app.model.TodoItem;
import com.example.todo_app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> findAll(){
        return todoRepository.findAll();
    }
    public Optional<TodoItem> findById(long id){
        return todoRepository.findById(id);
    }
    public TodoItem save(TodoItem todoItem){
        return todoRepository.save(todoItem);
    }
    public void deleteById(long id){
        todoRepository.deleteById(id);
    }
}
