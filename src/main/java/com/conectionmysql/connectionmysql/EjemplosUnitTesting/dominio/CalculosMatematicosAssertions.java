package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

public class CalculosMatematicosAssertions {

    public int calcularAreaCuadrado(int lado) {
        return lado * lado;
    }

    public int calcularPerimetroTriangulo(int lado1, int lado2, int lado3) {
        return lado1 + lado2 + lado3;
    }

    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

}
