package com.smartspend.smartspend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "budgets")
public class Budget {
    @Id
    private String id;
    private String category;
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String userId;
    private String month;
}
