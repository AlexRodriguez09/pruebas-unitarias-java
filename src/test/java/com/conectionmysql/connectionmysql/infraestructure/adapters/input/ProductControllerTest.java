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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

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
        when(iProductPort.updateProduct(anyInt(),anyString(),anyString())).thenReturn(true);
        ResponseEntity<String> response = productController.putProduct(productDTO);
        assertEquals("Product updated",response.getBody());
        assertEquals(200, HttpStatus.OK.value());

        verify(iProductPort,times(1)).updateProduct(anyInt(),anyString(),anyString());

    }

    @Test
    void putProductInvalid() {
        when(iProductPort.updateProduct(anyInt(),anyString(),anyString())).thenReturn(false);
        ResponseEntity<String> response = productController.putProduct(productDTO);
        assertEquals("Invalid product",response.getBody());
        assertEquals(200, HttpStatus.OK.value());

        verify(iProductPort,times(1)).updateProduct(anyInt(),anyString(),anyString());

    }

    @Test
    void deleteProduct() {
        when(iProductPersistence.deleteProduct(anyInt())).thenReturn(true);
        ResponseEntity<String> response = productController.deleteProduct(12);
        assertEquals("Deleted",response.getBody());
        assertEquals(200,HttpStatus.OK.value());
        verify(iProductPersistence,times(1)).deleteProduct(anyInt());
    }

    @Test
    void deleteProductDontExists() {
        when(iProductPersistence.deleteProduct(anyInt())).thenReturn(false);
        ResponseEntity<String> response = productController.deleteProduct(12);
        assertEquals("Product don't exists",response.getBody());
        assertEquals(200,HttpStatus.OK.value());

        verify(iProductPersistence,times(1)).deleteProduct(anyInt());
    }

    @Test
    void getProducts() {
        List<ProductJPA> productJPAList = new ArrayList<>();
        productJPAList.add(productJPA);

        when(iProductPersistence.getProducts()).thenReturn(productJPAList);
        ResponseEntity<List<ProductJPA>> response = productController.getProducts();
        assertEquals(productJPAList,response.getBody());

        verify(iProductPersistence,times(1)).getProducts();

    }

    @Test
    void getProductID() {
        when(iProductPersistence.getProductID(anyInt())).thenReturn(productJPA);
        ResponseEntity<ProductJPA> response = productController.getProductID(12);

        assertEquals(productJPA, response.getBody());
        assertEquals(200, HttpStatus.OK.value());

        verify(iProductPersistence,times(1)).getProductID(anyInt());
    }
}