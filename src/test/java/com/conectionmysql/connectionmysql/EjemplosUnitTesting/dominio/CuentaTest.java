package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    Cuenta cuenta;
    @BeforeEach
    void beforeEachTest(){
        System.out.println("Iniciando método");
        this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
    }

    @AfterEach
    void afterEach(){
        System.out.println("Finalizando el método");
    }
    @Test
    @DisplayName("Saldo cuenta")
    void testNombreCuenta(){
        System.out.println("Test de saldo cuenta");
        String esperado = "Andres";
        String real = this.cuenta.getPersona();
        assertEquals(esperado, real, () -> "El nombre esperado de la cuenta debe ser igual");
    }

    @Test
    @DisplayName("Test de referencia")
    void testReferenciaCuenta(){
        System.out.println("Test de referencia");
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotEquals(cuenta,cuenta2);
    }




}