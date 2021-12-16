package com.project.stationary.Model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "cart_product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    @Column
    private Integer productId;
    @Column
    private String productName;
    @Column
    private Double productPrice;
    @Column(columnDefinition ="integer default 1")
    private Integer productQty=1;
    @Column
    private String productImg;

}
