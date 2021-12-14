package com.tavant.stationary_shop.order.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ordered_product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    @Column
    private Integer productId;
    @Column
    private String productName;
    @Column
    private Integer productQty;
    @Column
    private Double productPrice;

}
