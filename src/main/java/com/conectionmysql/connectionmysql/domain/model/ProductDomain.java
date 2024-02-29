package com.conectionmysql.connectionmysql.domain.model;


import com.conectionmysql.connectionmysql.domain.exceptions.ProductException;

public class ProductDomain {

    private String nameProduct;
    private String typeProduct;

    public ProductDomain(String nameProduct, String typeProduct) {
        this.nameProduct = validateNameProduct(nameProduct);
        this.typeProduct = validatetypeProduct(typeProduct);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = validateNameProduct(nameProduct);
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = validatetypeProduct(typeProduct);
    }

    public String validateNameProduct(String nameProduct){
        if (nameProduct.matches("[a-zA-Z0-9]+")){
            return nameProduct;
        }
        throw new ProductException("Invalid name of product");
    }

    public String validatetypeProduct(String typeProduct){
        if (typeProduct.equals("Renta fija") || typeProduct.equals("Renta variable") || typeProduct.equals("Derivado")){
            return typeProduct;
        }
        throw new ProductException("Invalid type of product");
    }


}
