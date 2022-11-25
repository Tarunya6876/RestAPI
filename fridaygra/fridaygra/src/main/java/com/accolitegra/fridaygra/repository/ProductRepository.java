package com.accolitegra.fridaygra.repository;

import com.accolitegra.fridaygra.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
