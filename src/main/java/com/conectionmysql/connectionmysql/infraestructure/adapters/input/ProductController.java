package com.conectionmysql.connectionmysql.infraestructure.adapters.input;

import com.conectionmysql.connectionmysql.application.ports.input.IProductPort;
import com.conectionmysql.connectionmysql.application.ports.output.IProductPersistence;
import com.conectionmysql.connectionmysql.infraestructure.dto.ProductDTO;
import com.conectionmysql.connectionmysql.infraestructure.jpa.ProductJPA;
import org.mockito.internal.matchers.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/v1/product")
public class ProductController {

    private final IProductPort iProductPort;
    private final IProductPersistence iProductPersistence;

    public ProductController(IProductPort iProductPort, IProductPersistence iProductPersistence) {
        this.iProductPort = iProductPort;
        this.iProductPersistence = iProductPersistence;
    }

    @PostMapping("")
    public ResponseEntity<String> postProduct(@RequestBody ProductDTO productDTO){
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Product created",HttpStatus.CREATED);
        iProductPort.createProduct(productDTO.getNameProduct(), productDTO.getTypeProduct());
        return responseEntity;
    }

    @PutMapping("")
    public ResponseEntity<String> putProduct(@RequestBody ProductDTO productDTO){
        String response = "Product updated";
        iProductPort.updateProduct(productDTO.getIdProduct(), productDTO.getNameProduct(), productDTO.getTypeProduct());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        String response = "Deleted";
        iProductPersistence.deleteProduct(id);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @GetMapping("")
    public ResponseEntity<List<ProductJPA>> getProducts(){
        List<ProductJPA> productDTOS = iProductPersistence.getProducts();
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductJPA> getProductID(@PathVariable Integer id){
        ProductJPA productJPA = iProductPersistence.getProductID(id);
        return new ResponseEntity<>(productJPA, HttpStatus.OK);
    }

}
