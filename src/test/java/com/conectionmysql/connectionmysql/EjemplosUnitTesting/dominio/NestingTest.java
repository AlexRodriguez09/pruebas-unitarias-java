package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class NestingTest {

    @Nested
    @DisplayName("Lista vacía")
    class ArrayListIsEmpty{
        ArrayList<String> empty = new ArrayList<>();

        @Test
        void vacio(){
            assertTrue(empty.isEmpty());
        }

        @Test
        void size() {
            assertEquals(0, empty.size());
        }
    }

    @Nested
    @DisplayName("Lista llena")
    class ArrayListNoEmpy{
            ArrayList<String> vocales = new ArrayList<>(Arrays.asList("a","b","c","d"));

        @Test
        void vacio(){
            assertFalse(vocales.isEmpty());
        }

        @Test
        void size(){
            assertEquals(4, vocales.size());
        }
    }
}
