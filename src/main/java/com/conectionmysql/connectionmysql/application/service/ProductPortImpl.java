package com.conectionmysql.connectionmysql.application.service;

import com.conectionmysql.connectionmysql.application.ports.input.IProductPort;
import com.conectionmysql.connectionmysql.application.ports.output.IProductPersistence;
import com.conectionmysql.connectionmysql.domain.model.ProductDomain;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;
import org.mockito.internal.matchers.Null;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductPortImpl implements IProductPort {

    private final IProductPersistence iProductPersistence;

    public ProductPortImpl(IProductPersistence iProductPersistence) {
        this.iProductPersistence = iProductPersistence;
    }

    @Override
    public void createProduct(String nameProduct, String typeProduct) {
        Optional<ProductDomain> optionalProductDomain = Optional.of(new ProductDomain(nameProduct, typeProduct));
        ProductDomain productDomain = optionalProductDomain.orElseThrow(IllegalArgumentException::new);
        try{
            iProductPersistence.createProduct(productDomain);
        }catch(Exception exception){
            throw new RuntimeException("No se pudo crear producto");
        }
    }

    @Override
    public void updateProduct(Integer idProduct, String nameProduct, String typeProduct) {
        ProductJPA productJPA = existProduct(idProduct);
        if (productJPA != null){
            iProductPersistence.updateProduct(idProduct, new ProductDomain(nameProduct,typeProduct));
        }else{
            throw new RuntimeException("El producto no existe en la base de datos");
        }

    }

    private ProductJPA existProduct(Integer idProduct){
        return iProductPersistence.getProductID(idProduct);
    }
}
