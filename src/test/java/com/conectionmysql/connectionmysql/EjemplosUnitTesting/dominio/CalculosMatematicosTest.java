package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

class CalculosMatematicosTest {
    CalculosMatematicosAssertions calculosMatematicosAssertions = new CalculosMatematicosAssertions();

    @Test
    @DisplayName("Area Cuadrado")
    void calcularAreaCuadrado() {
        int lado = 5;
        int areaEsperada = 25;
        int areaCalculada = calculosMatematicosAssertions.calcularAreaCuadrado(lado);
        // Queremos validar que el valor esperado y obtenido son iguales
        assertEquals(areaEsperada, areaCalculada);
    }

    @Test
    @DisplayName("Perimetro triangulo")
    void calcularPerimetroTriangulo() {
        int lado1 = 3;
        int lado2 = 4;
        int lado3 = 5;
        int perimetroEsperado = 13;
        int perimetroCalculado = calculosMatematicosAssertions.calcularPerimetroTriangulo(lado1, lado2, lado3);
        // Queremos validar que el valor esperado y obtenido sean diferentes
        assertNotEquals(perimetroEsperado, perimetroCalculado);
    }

    @Test
    @DisplayName("Par")
    void esPar() {
        int numero = 10;
        assertTrue(calculosMatematicosAssertions.esPar(numero));
    }

    @Test
    @DisplayName("Par")
    void esImpar() {
        int numero = 9;
        assertFalse(calculosMatematicosAssertions.esPar(numero));
    }

    @Test
    @DisplayName("Assert Null")
    void assertNullEjemplo(){
        CalculosMatematicosAssertions calculosMatematicosAssertions1 = null;
        assertNull(calculosMatematicosAssertions1);
    }

    @Test
    @DisplayName("Assert Not Null")
    void assertNotNullEjemplo(){
        CalculosMatematicosAssertions calculosMatematicosAssertions = new CalculosMatematicosAssertions();
        assertNotNull(calculosMatematicosAssertions);
    }

    @Test
    @DisplayName("Assert Throws")
    void testNullPointerException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            str.length();
        });
    }

    @Test
    @DisplayName("Disabled")
    @Disabled
    void testDisabled() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            str.length();
        });
    }

    @Test
    @DisplayName("Assert All")
    void testAssertAll() {
        assertAll("Validar propiedades del usuario",
                () -> assertEquals(calculosMatematicosAssertions.calcularAreaCuadrado(5), 25),
                () -> assertNotEquals("Andres", "AnDrEs"),
                () -> assertTrue(calculosMatematicosAssertions.esPar(2)),
                () -> assertFalse(calculosMatematicosAssertions.esPar(3))
        );
    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    public void shouldRunBothWindowsAndMac() {
        //...
    }

}