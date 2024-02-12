package com.conectionmysql.connectionmysql.infraestructure.adapters.input;

import com.conectionmysql.connectionmysql.application.ports.input.IProductPort;
import com.conectionmysql.connectionmysql.application.ports.output.IProductPersistence;
import com.conectionmysql.connectionmysql.domain.model.ProductDomain;
import com.conectionmysql.connectionmysql.infraestructure.dto.ProductDTO;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private IProductPort iProductPort;

    @Mock
    private IProductPersistence iProductPersistence;

    @InjectMocks
    private ProductController productController;

    private ProductJPA productJPA;
    private ProductDomain productDomain;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        productJPA = new ProductJPA("Product","Renta fija");
        productDomain = new ProductDomain("Product","Renta fija");
        productDTO = new ProductDTO(0,"Product","Renta fija");

    }

    @Test
    void postProduct() {
        when(iProductPort.createProduct(anyString(),anyString())).thenReturn(productJPA);
        ResponseEntity<String> response = productController.postProduct(productDTO);
        assertEquals("Product created",response.getBody());
        assertEquals(201,response.getStatusCode().value());

        verify(iProductPort,times(1)).createProduct(anyString(),anyString());
    }

    @Test
    void postProductInvalid() {
        when(iProductPort.createProduct(anyString(),anyString())).thenReturn(null);
        ResponseEntity<String> response = productController.postProduct(productDTO);
        assertEquals("Invalid product",response.getBody());
        assertEquals(400,response.getStatusCode().value());

        verify(iProductPort,times(1)).createProduct(anyString(),anyString());
    }

    @Test
    void putProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getProducts() {
    }

    @Test
    void getProductID() {
    }
}