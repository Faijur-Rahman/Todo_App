package com.todo.project.service;

import com.todo.project.model.Todo;
import com.todo.project.payload.TodoPatchDTO;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();

    void addTodo(Todo todo);

    void updateTodoById(Long todoId, TodoPatchDTO todoPatchDTO);

    void deleteTodoById(Long todoId);
}
