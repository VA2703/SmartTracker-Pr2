package com.smartspend.smartspend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;

    private String category;
    private String description;
    private double amount;
    private LocalDate date;

    private String userId; // store user ID directly
}
