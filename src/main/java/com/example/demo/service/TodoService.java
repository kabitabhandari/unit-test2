package com.example.demo.service;

import java.util.List;

public interface TodoService {

     public List<String> retrieveTodos(String user);
     public void deleteTodo(String todo);
}
