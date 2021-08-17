package com.example.demo.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class ListTest {

    @Test
    public void testSingleValue() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }
    @Test
    public void testMultipleValue() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void testMockGet() {
        List listMock = mock(List.class);
        //Argument matcher
        when(listMock.get(anyInt())).thenReturn("Lucy is my dog!");
        assertEquals("Lucy is my dog!", listMock.get(0));

    }


    // With junit 4 it allows us @Test(expected = RuntimeException.class), but with junit 5 we use  Assertions.assertThrows
    @Test
    public void letsMockListGetToThrowException() {
        List<String> list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something went wrong"));
        Assertions.assertThrows(RuntimeException.class, () -> {list.get(0);});
    }


}
