package com.ran.kafka.producer.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Order {

    private int orderId;
    private List<LineItem> itemList;
    private Customer customer;
}
