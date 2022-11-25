package com.accolitegra.fridaygra.controller;

import com.accolitegra.fridaygra.model.Product;
import com.accolitegra.fridaygra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product")
    private ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(this.productService.getProducts());
    }
    @GetMapping("/product/{productID}")
    private Product getProductById(@PathVariable long productID){
        return this.productService.getProById(productID);

    }
    @PostMapping("/products")
    private ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.createPro(product));
    }

    @PutMapping("/products/{productID}")
    private ResponseEntity<Product> updateProduct(@PathVariable long productID,@RequestBody Product product){
        product.setProductID(productID);
        return ResponseEntity.ok().body(this.productService.updatePro(product));
    }
    @DeleteMapping("/product/{productID}")
    private HttpStatus deleteProduct(@PathVariable long productID){
        this.productService.deletePro(productID);
        return HttpStatus.OK;
    }


}
