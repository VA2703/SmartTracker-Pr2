package com.smartspend.smartspend.service;

import com.smartspend.smartspend.model.Expense;
import com.smartspend.smartspend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(String id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public List<Expense> getExpensesByUserId(String userId) {
        return expenseRepository.findByUserId(userId);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(String id, Expense updatedExpense) {
        Optional<Expense> optional = expenseRepository.findById(id);
        if (optional.isPresent()) {
            Expense expense = optional.get();
            expense.setCategory(updatedExpense.getCategory());
            expense.setDescription(updatedExpense.getDescription());
            expense.setAmount(updatedExpense.getAmount());
            expense.setDate(updatedExpense.getDate());
            expense.setUserId(updatedExpense.getUserId());
            return expenseRepository.save(expense);
        } else {
            return null;
        }
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
