package com.conectionmysql.connectionmysql.infraestructure.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "product", catalog ="market")
public class ProductJPA {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "type_product")
    private String typeProduct;

    public ProductJPA( Integer idProduct,String nameProduct, String typeProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
    }

    public ProductJPA( String nameProduct, String typeProduct) {
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
    }


    public ProductJPA() {
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }
}
