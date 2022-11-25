package com.accolitegra.fridaygra.service;

import com.accolitegra.fridaygra.exception.ProductException;
import com.accolitegra.fridaygra.model.Product;
import com.accolitegra.fridaygra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createPro(Product pro) {
        return productRepository.save(pro);
    }

    @Override
    public Product updatePro(Product pro) {
        Optional<Product> proObj = this.productRepository.findById(pro.getProductID());
        if (proObj.isPresent()) {
            Product proUpdate = proObj.get();
            proUpdate.setProductName(pro.getProductName());
            proUpdate.setProductID(pro.getProductID());
            proUpdate.setProductQuantity(pro.getProductQuantity());
            return this.productRepository.save(proUpdate);
        } else {
            throw new ProductException("Product doesn't exist with this ID" + pro.getProductID());
        }
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProById(long productID) {
        Optional<Product> proObj = this.productRepository.findById(productID);
        if (proObj.isPresent()) {
            return proObj.get();
        } else {
            throw new ProductException("Product doesnt exist with this ID" + productID);
        }
    }

    @Override
    public void deletePro(long productID) {
        Optional<Product> proObj = this.productRepository.findById(productID);
        if (proObj.isPresent()) {
            this.productRepository.deleteById(productID);
        } else {
            throw new ProductException("Product doesnt exist with this ID" + productID);
        }
    }
}


