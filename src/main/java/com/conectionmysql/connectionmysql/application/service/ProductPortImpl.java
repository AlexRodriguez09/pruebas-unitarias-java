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
    public ProductJPA createProduct(String nameProduct, String typeProduct) {
        Optional<ProductDomain> optionalProductDomain = Optional.of(new ProductDomain(nameProduct, typeProduct));
        ProductDomain productDomain = optionalProductDomain.orElseThrow(IllegalArgumentException::new);
        return iProductPersistence.createProduct(productDomain);
    }

    @Override
    public boolean updateProduct(Integer idProduct, String nameProduct, String typeProduct) {
        boolean result = true;
        ProductJPA productJPA = existProduct(idProduct);
        if (productJPA != null){
            iProductPersistence.updateProduct(idProduct, new ProductDomain(nameProduct,typeProduct));
        }else{
            result = false;
        }
        return result;

    }

    private ProductJPA existProduct(Integer idProduct){
        return iProductPersistence.getProductID(idProduct);
    }
}
