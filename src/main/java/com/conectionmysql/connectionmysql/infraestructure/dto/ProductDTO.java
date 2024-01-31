package com.conectionmysql.connectionmysql.infraestructure.dto;

import org.springframework.validation.annotation.Validated;

public class ProductDTO {

    protected Integer idProduct;
    protected String nameProduct;
    protected String typeProduct;

    public ProductDTO(Integer idProduct, String nameProduct, String typeProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
    }

    public ProductDTO() {
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }
}
