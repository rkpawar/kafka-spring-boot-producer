package com.ran.kafka.producer.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LineItem {

    private int productId;
    private String productName;
    private int qauntity;
    private double price;
}
