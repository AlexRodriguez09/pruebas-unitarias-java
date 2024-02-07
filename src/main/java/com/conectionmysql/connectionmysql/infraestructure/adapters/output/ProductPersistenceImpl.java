package com.conectionmysql.connectionmysql.infraestructure.adapters.output;

import com.conectionmysql.connectionmysql.application.ports.output.IProductPersistence;
import com.conectionmysql.connectionmysql.domain.model.ProductDomain;
import com.conectionmysql.connectionmysql.infraestructure.jpa.IProductRepository;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductPersistenceImpl implements IProductPersistence {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public ProductJPA createProduct(ProductDomain productDomain) {
        return iProductRepository.save(new ProductJPA(productDomain.getNameProduct(), productDomain.getTypeProduct()));
    }

    @Override
    public boolean updateProduct(Integer idProduct, ProductDomain productDomain) {
        iProductRepository.save(new ProductJPA(idProduct,productDomain.getNameProduct(), productDomain.getTypeProduct()));
        return  true;
    }

    @Override
    public boolean deleteProduct(Integer idProduct) {
        iProductRepository.deleteById(idProduct);
        return  true;

    }

    @Override
    public ProductJPA getProductID(Integer idProduct) {
        return iProductRepository.findById(idProduct)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + idProduct));

    }

    @Override
        public List<ProductJPA> getProducts() {
        return iProductRepository.findAll();
    }


}
