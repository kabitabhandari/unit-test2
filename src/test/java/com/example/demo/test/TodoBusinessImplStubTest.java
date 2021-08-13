package com.example.demo.test;

import com.example.demo.data.api.TodoServiceStub;
import com.example.demo.service.TodoService;
import com.example.demo.service.impl.TodoBusinessImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodoBusinessImplStubTest {

    @Test
    public void retrieveTodosRelatedToSpring_shouldReturnTodos(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> allTTodosRelatedToSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("kabita");
        Assertions.assertEquals("spring Hiking", allTTodosRelatedToSpring.get(0));
        Assertions.assertEquals(3, allTTodosRelatedToSpring.size());
    }
}
