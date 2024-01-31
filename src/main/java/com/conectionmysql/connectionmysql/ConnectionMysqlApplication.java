package com.conectionmysql.connectionmysql;

import com.conectionmysql.connectionmysql.application.ports.input.IProductPort;
import com.conectionmysql.connectionmysql.application.ports.output.IProductPersistence;
import com.conectionmysql.connectionmysql.application.service.ProductPortImpl;
import com.conectionmysql.connectionmysql.infraestructure.adapters.input.ProductController;
import com.conectionmysql.connectionmysql.infraestructure.adapters.output.ProductPersistenceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.conectionmysql.connectionmysql"})
@EnableJpaRepositories(basePackages = "com.conectionmysql.connectionmysql.infraestructure.jpa")
@EnableTransactionManagement
@EntityScan(basePackages = "com.conectionmysql.connectionmysql.infraestructure.jpa")
public class ConnectionMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionMysqlApplication.class, args);

		IProductPersistence productPersistence = new ProductPersistenceImpl();
		IProductPort productPort = new ProductPortImpl(productPersistence);

		ProductController productController = new ProductController(productPort,productPersistence);

	}

}
