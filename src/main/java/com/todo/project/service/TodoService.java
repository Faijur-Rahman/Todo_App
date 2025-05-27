package com.todo.project.service;

import com.todo.project.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();

    void addTodo(Todo todo);

    void updateTodoById(Long todoId, Todo todo);

    void deleteTodoById(Long todoId);
}
