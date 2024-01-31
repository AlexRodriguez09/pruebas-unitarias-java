package com.conectionmysql.connectionmysql.infraestructure.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductJPA,Integer> {
}
