package com.conectionmysql.connectionmysql.application.ports.output;

import com.conectionmysql.connectionmysql.domain.model.ProductDomain;
import com.conectionmysql.connectionmysql.infraestructure.dto.ProductDTO;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;

import java.util.List;

public interface IProductPersistence {

    boolean createProduct(ProductDomain productDomain);

    boolean deleteProduct(Integer idProduct);

    ProductJPA getProductID(Integer idProduct);

    List<ProductJPA> getProducts();

    boolean updateProduct(Integer idProduct, ProductDomain productDomain);
}
