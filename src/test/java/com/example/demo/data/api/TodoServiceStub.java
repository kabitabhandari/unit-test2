package com.example.demo.data.api;

import com.example.demo.service.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {

        return Arrays.asList("spring Hiking","clubbing","spring tennis","spring swimming");
    }

    @Override
    public void deleteTodo(String todo) {


    }
}