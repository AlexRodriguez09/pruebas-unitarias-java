package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    @DisplayName("Get Persona")
    void getPersona() {
        Cuenta cuenta = new Cuenta();
        cuenta.setPersona("Raul");
        cuenta.setSaldo(new BigDecimal("100000000000"));

    }

    @Test
    void setPersona() {
    }

    @Test
    void getSaldo() {
    }

    @Test
    void setSaldo() {
    }
}