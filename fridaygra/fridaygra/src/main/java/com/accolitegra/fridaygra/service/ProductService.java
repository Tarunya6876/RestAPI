package com.accolitegra.fridaygra.service;

import com.accolitegra.fridaygra.model.Product;

import java.util.List;

public interface ProductService {
    Product createPro(Product pro);
    Product updatePro(Product pro);
    List<Product> getProducts();
    Product getProById(long productID);
    void deletePro(long productID);
}
