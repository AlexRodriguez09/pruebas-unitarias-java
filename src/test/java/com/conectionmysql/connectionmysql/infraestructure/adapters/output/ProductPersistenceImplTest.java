package com.conectionmysql.connectionmysql.infraestructure.adapters.output;

import com.conectionmysql.connectionmysql.domain.model.ProductDomain;
import com.conectionmysql.connectionmysql.infraestructure.jpa.IProductRepository;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductPersistenceImplTest {

    @Mock
    private IProductRepository iProductRepository;

    @InjectMocks
    private ProductPersistenceImpl productPersistence;

    @Captor
    ArgumentCaptor<ProductJPA> argumentCaptor;

    private ProductJPA productJPA;
    private ProductDomain productDomain;


    @BeforeEach
    void setUp() {
        productJPA = new ProductJPA("Product","Renta fija");
        productDomain = new ProductDomain("Product","Renta fija");

    }

    @Test
    void createProduct() {
        //Arrange
        when(iProductRepository.save(any())).thenReturn(productJPA);

        //Act
        ProductJPA actualProductJPA = productPersistence.createProduct(productDomain);

        //Assert
        assertEquals(actualProductJPA, productJPA);
        assertEquals(actualProductJPA, iProductRepository.save(productJPA));

        verify(iProductRepository,times(1)).save(productJPA);
        verify(iProductRepository,times(2)).save(argumentCaptor.capture());
        assertEquals(actualProductJPA,argumentCaptor.getValue() );

    }

    @Test
    void updateProduct() {
        doReturn(productJPA).when(iProductRepository).save(any());

        assertEquals(productJPA, iProductRepository.save(productJPA));
        assertTrue(productPersistence.updateProduct(anyInt(),productDomain));
        verify(iProductRepository, times(1)).save(productJPA);
    }

    @Test
    void deleteProduct() {
        doNothing().when(iProductRepository).deleteById(anyInt());
        assertTrue(productPersistence.deleteProduct(anyInt()));

    }

    @Test
    void getProductID() {
        when(iProductRepository.findById(anyInt())).thenReturn(Optional.of(productJPA));
        assertTrue(iProductRepository.findById(anyInt()).isPresent());

        ProductJPA actualProductJPA = productPersistence.getProductID(anyInt());
        assertEquals(productJPA, actualProductJPA);

    }

    @Test
    void getProductIDNotFound() {
        when(iProductRepository.findById(12)).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class,() ->  iProductRepository.findById(12));
    }

    @Test
    void getProducts() {
        List<ProductJPA> productJPAList = Arrays.asList(
                new ProductJPA("Uno","Renta fija"),
                new ProductJPA("Dos", "Derivados")
        );

        when(iProductRepository.findAll()).thenReturn(productJPAList);

        List<ProductJPA> actualProductJPAS = productPersistence.getProducts();

        assertEquals(productJPAList,actualProductJPAS);

        verify(iProductRepository,times(1)).findAll();
    }
}