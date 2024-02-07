package com.conectionmysql.connectionmysql.application.service;

import com.conectionmysql.connectionmysql.application.ports.output.IProductPersistence;
import com.conectionmysql.connectionmysql.domain.model.ProductDomain;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductPortImplTest {

    @Mock
    private IProductPersistence iProductPersistence;

    @InjectMocks
    private ProductPortImpl productPort;

    private ProductDomain productDomain;
    private ProductJPA productJPA;

    @BeforeEach
    void setUp(){
        productDomain = new ProductDomain("Producto","Renta fija");
        productJPA = new ProductJPA("Producto","Renta fija");
    }



    @Test
    void createProduct() {
        lenient().when(iProductPersistence.createProduct(any())).thenReturn(productJPA);
        assertEquals("Renta fija",iProductPersistence.createProduct(productDomain).getTypeProduct());
        verify(iProductPersistence,times(1)).createProduct(any());
        assertEquals(productJPA,productPort.createProduct("Producto","Renta fija"));
    }

    @Test
    void updateProduct() {
        lenient().when(iProductPersistence.getProductID(anyInt())).thenReturn(productJPA);
        //doNothing().when(iProductPersistence.updateProduct(anyInt(),any()));
        boolean result = productPort.updateProduct(anyInt(),"Producto","Renta fija");
        assertTrue(result);

    }

    @Test
    void updateProductFailed() {
        lenient().when(iProductPersistence.getProductID(anyInt())).thenReturn(null);
        //doNothing().when(iProductPersistence.updateProduct(anyInt(),any()));
        boolean result = productPort.updateProduct(anyInt(),"Producto","Renta fija");
        assertFalse(result);

    }
}