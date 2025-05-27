package com.todo.project.controller;

import com.todo.project.model.Todo;
import com.todo.project.payload.TodoPatchDTO;
import com.todo.project.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos,HttpStatus.OK);
    }

    @PostMapping("/todos")
    public ResponseEntity<String> addTodo(@Valid @RequestBody Todo todo) {
        todoService.addTodo(todo);
       return new ResponseEntity<>("Todo added successfully !!!",HttpStatus.OK);
    }

    @PatchMapping("/todos/{todoId}")
    public ResponseEntity<String> updateTodo(@PathVariable("todoId") Long todoId, @Valid @RequestBody TodoPatchDTO todoPatchDTO) {
        todoService.updateTodoById(todoId,todoPatchDTO);

        return new ResponseEntity<>("Todo with Id: " + todoId + " Updated successfully !!!",HttpStatus.OK);
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<String > deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodoById(todoId);
        return new ResponseEntity<>("Todo with Id: " + todoId + " deleted successfully !!!",HttpStatus.OK);
    }
}
