package com.project.stationary.UIandUO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserOutputProduct {

    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer productQty;
    private String productImg;
}
