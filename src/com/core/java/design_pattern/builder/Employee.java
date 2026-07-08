package com.core.java.design_pattern.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Employee {

    public Employee() {

    }

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;

}
