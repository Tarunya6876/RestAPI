package com.accolitegra.fridaygra.model;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long productID;
    @Column(name="productName")
    private String productName;

    @Column(name="productQuantity")
    private long productQuantity;

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }
}
