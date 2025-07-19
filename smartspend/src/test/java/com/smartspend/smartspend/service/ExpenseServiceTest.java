package com.smartspend.smartspend.service;

import com.smartspend.smartspend.model.Expense;
import com.smartspend.smartspend.repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllExpenses() {
        Expense e1 = new Expense("1", "Food", "Lunch", 150.0, LocalDate.of(2025, 7, 1), "user123");
        Expense e2 = new Expense("2", "Travel", "Bus Ticket", 40.0, LocalDate.of(2025, 7, 2), "user123");

        List<Expense> mockExpenses = Arrays.asList(e1, e2);
        when(expenseRepository.findAll()).thenReturn(mockExpenses);

        List<Expense> result = expenseService.getAllExpenses();

        assertEquals(2, result.size());
        assertEquals("Lunch", result.get(0).getDescription());
        assertEquals("Bus Ticket", result.get(1).getDescription());
    }
}
