package com.conectionmysql.connectionmysql.application.ports.input;

public interface IProductPort {

    boolean createProduct(String nameProduct, String typeProduct);
    boolean updateProduct(Integer idProduct, String nameProduct, String typeProduct);
}
