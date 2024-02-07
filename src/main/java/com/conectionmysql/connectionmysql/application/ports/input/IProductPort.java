package com.conectionmysql.connectionmysql.application.ports.input;

import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;

public interface IProductPort {

    ProductJPA createProduct(String nameProduct, String typeProduct);
    boolean updateProduct(Integer idProduct, String nameProduct, String typeProduct);
}
