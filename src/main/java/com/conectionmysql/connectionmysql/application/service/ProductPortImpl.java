package com.conectionmysql.connectionmysql.application.service;

import com.conectionmysql.connectionmysql.application.ports.input.IProductPort;
import com.conectionmysql.connectionmysql.application.ports.output.IProductPersistence;
import com.conectionmysql.connectionmysql.domain.model.ProductDomain;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductPortImpl implements IProductPort {

    private IProductPersistence iProductPersistence;

    public ProductPortImpl(IProductPersistence iProductPersistence) {
        this.iProductPersistence = iProductPersistence;
    }

    @Override
    public boolean createProduct(String nameProduct, String typeProduct) {
        Optional<ProductDomain> optionalProductDomain = Optional.ofNullable(new ProductDomain(nameProduct, typeProduct));
        ProductDomain productDomain = optionalProductDomain.orElseThrow(IllegalArgumentException::new);
        return iProductPersistence.createProduct(productDomain);
    }

    @Override
    public boolean updateProduct(Integer idProduct, String nameProduct, String typeProduct) {
        // Get and modify the product;
        return true;

    }

    private ProductJPA existProduct(Integer idProduct){
        return iProductPersistence.getProductID(idProduct);
    }
}
