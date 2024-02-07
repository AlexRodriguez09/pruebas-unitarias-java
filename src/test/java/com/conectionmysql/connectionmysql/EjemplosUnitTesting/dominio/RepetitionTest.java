package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;


public class RepetitionTest {
    @DisplayName("Repetición")
    @RepeatedTest(value = 5, name= "Repetición {currentRepetition} de {totalRepetition}")
    void testRepeated(){
        double numeroAleatorio = Math.random();
        assertTrue(numeroAleatorio >= 0 && numeroAleatorio <60);
    }
}
