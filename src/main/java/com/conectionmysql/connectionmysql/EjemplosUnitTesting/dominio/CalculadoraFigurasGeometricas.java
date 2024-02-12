package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

public class CalculadoraFigurasGeometricas {

    public double areaCuadrado(double lado){
        if (lado < 0){
            throw new RuntimeException("Lado invalido");
        }
        return lado * lado;

    }

    public double perimetroTriangulo(double lado1, double lado2, double lado3){

        if (lado1 < 0 || lado2 <0 || lado3 < 0){
            throw new RuntimeException("Alguno de los lados es invalido");
        }
        return lado1 + lado2 + lado3;
    }

    public double areaCirculo(double radio){
        if (radio < 0){
            throw new RuntimeException("Radio invalido");
        }
        return Math.PI * Math.pow(radio,2);

    }


}
