package com.tavant.stationary_shop.product.model;

//import lombok.*;

import javax.persistence.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column
    private String productName;
    @Column
    private Double productPrice;
    @Column
    private Integer productMaxQty;
    @Column
    private String productImg;

    public Product(Integer productId, String productName, Double productPrice, Integer productMaxQty, String productImg) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productMaxQty = productMaxQty;
        this.productImg = productImg;
    }

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductMaxQty() {
        return productMaxQty;
    }

    public void setProductMaxQty(Integer productMaxQty) {
        this.productMaxQty = productMaxQty;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
