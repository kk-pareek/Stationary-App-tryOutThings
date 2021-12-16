package com.project.stationary.UIandUO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserOutputCart {

    private Integer customerId;

    private List<UserOutputProduct> products;
}
