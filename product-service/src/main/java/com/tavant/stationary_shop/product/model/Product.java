package com.tavant.stationary_shop.product.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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

}
