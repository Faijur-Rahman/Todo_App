package com.todo.project.service;

import com.todo.project.model.Todo;
import com.todo.project.payload.TodoPatchDTO;
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
    public void updateTodoById(Long todoId, TodoPatchDTO todoPatchDTO) {

        Todo existingTodo = todoRepository.findById(todoId).orElseThrow(() -> new EntityNotFoundException("Todo not found with ID: " + todoId));

        if (todoPatchDTO.getDescription() != null) {
            existingTodo.setDescription(todoPatchDTO.getDescription());
        }
        if (todoPatchDTO.getTitle() != null) {
            existingTodo.setTitle(todoPatchDTO.getTitle());
        }
        if (todoPatchDTO.getCompleted() != null) {
            existingTodo.setCompleted(todoPatchDTO.getCompleted());
        }

        todoRepository.save(existingTodo);
    }

    @Override
    public void deleteTodoById(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
