package com.conectionmysql.connectionmysql.domain.model;

import com.conectionmysql.connectionmysql.domain.exceptions.ProductException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

class ProductDomainTest {

    private ProductDomain productDomain;

    @BeforeEach
    void setUp(){
         productDomain = new ProductDomain("nameProduct","Renta fija");
    }
    @Test
    void validateNameProduct() {
        assertEquals("Value",productDomain.validateNameProduct("Value"));
    }

    @Test
    void validateNameProductInvalid(){
        assertAll("Nombre de productos invalidos",
                () -> assertThrows(ProductException.class, () -> productDomain.validateNameProduct("Nombre@")),
                () -> assertThrows(ProductException.class, () -> productDomain.validateNameProduct("Nombre De"))
        );
    }
    @Test
    void validarSpy(){
        ProductDomain productDomainMock = Mockito.mock(ProductDomain.class);
        productDomainMock.setNameProduct("Nombre");
        System.out.println(productDomainMock.getNameProduct());

        ProductDomain productDomainSpy = Mockito.spy(new ProductDomain("Nombre","Renta fija"));
        productDomainSpy.setNameProduct("Name");
        System.out.println(productDomainSpy.getNameProduct());
    }

    @Test
    void validatetypeProduct() {
        assertAll("Validando tipo de producto",
                () -> assertEquals("Renta fija", productDomain.validatetypeProduct("Renta fija")),
                () -> assertEquals("Renta variable", productDomain.validatetypeProduct("Renta variable")),
                () -> assertEquals("Derivado", productDomain.validatetypeProduct("Derivado"))
                );
    }

    @Test
    void validatetypeProductInvalid() {
        assertThrows(ProductException.class,() -> productDomain.validatetypeProduct("Nombre Producto"));
    }
}