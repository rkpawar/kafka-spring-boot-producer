package com.ran.kafka.producer.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Customer {

    private int custId;
    private String name;
    private Address address;
}
