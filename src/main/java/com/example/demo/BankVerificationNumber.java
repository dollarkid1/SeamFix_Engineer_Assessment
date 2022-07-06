package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class BankVerificationNumber {
    @Id
    private Long id;
    private String name;
    private String number;
}
