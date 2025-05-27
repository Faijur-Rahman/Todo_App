package com.todo.project.service;

import com.todo.project.model.Todo;
import com.todo.project.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
       return todoRepository.findAll();
    }

    @Override
    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void updateTodoById(Long todoId, Todo todo) {

        Todo existingTodo = todoRepository.findById(todoId).orElseThrow(() -> new EntityNotFoundException("Todo not found with ID: " + todoId));

        if (todo.getDescription() != null) {
            existingTodo.setDescription(todo.getDescription());
        }
        if (todo.getTitle() != null) {
            existingTodo.setTitle(todo.getTitle());
        }
        if (todo.getCompleted() != null) {
            existingTodo.setCompleted(todo.getCompleted());
        }

        todoRepository.save(existingTodo);
    }

    @Override
    public void deleteTodoById(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
