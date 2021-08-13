package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

import com.example.demo.service.TodoService;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodoBusinessImpl {
    private final TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodosArray = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("spring")) {
                filteredTodosArray.add(todo);
            }
        }
        return filteredTodosArray;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("spring")) {
                todoService.deleteTodo(todo);
            }
        }
    }
}





























