package com.smartspend.smartspend.service;

import com.smartspend.smartspend.model.Budget;
import com.smartspend.smartspend.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public List<Budget> getBudgetsByUserId(String userId) {
        return budgetRepository.findByUserId(userId);
    }

    public Budget getBudgetById(String id) {
        Optional<Budget> budget = budgetRepository.findById(id);
        return budget.orElse(null);
    }

    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(String id) {
        budgetRepository.deleteById(id);
    }
}
