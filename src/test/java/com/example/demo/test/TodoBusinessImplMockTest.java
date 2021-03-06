package com.example.demo.test;

import com.example.demo.service.TodoService;
import com.example.demo.service.impl.TodoBusinessImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


public class TodoBusinessImplMockTest {
    @Test
    public void retrieveTodosRelatedToSpring_shouldReturnTodos() {
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        List<String> allTodos = Arrays.asList("spring class", "spring day", "something else");
        when(todoService.retrieveTodos("kabita")).thenReturn(allTodos);
        List<String> myFilteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("kabita");
        Assertions.assertEquals(2, myFilteredTodos.size());
    }
    @Test
    public void retrieveTodosRelatedToSpring_shouldReturnTodosUsingBDD() {
        //when-thenReturn
        //given-willReturn

        //Given
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        List<String> allTodos = Arrays.asList("spring class", "spring day", "something else");
        //when(todoService.retrieveTodos("kabita")).thenReturn(allTodos);
        given(todoService.retrieveTodos("kabita")).willReturn(allTodos);

        //when -> call actual method
        List<String> myFilteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("kabita");

        //Then
        Assertions.assertEquals(2, myFilteredTodos.size());
        assertThat(myFilteredTodos.size(), is(2));
    }

    @Test
    public void letsTestDeleteNow() {

        TodoService todoService = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("kabita")).thenReturn(allTodos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("kabita");

        verify(todoService).deleteTodo("Learn to Dance");

        verify(todoService, never()).deleteTodo("Learn Spring MVC");

        verify(todoService, never()).deleteTodo("Learn Spring");

        verify(todoService, times(1)).deleteTodo("Learn to Dance");

    }
}

