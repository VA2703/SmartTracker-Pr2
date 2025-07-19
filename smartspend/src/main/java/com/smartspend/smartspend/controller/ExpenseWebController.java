package com.smartspend.smartspend.controller;

import com.smartspend.smartspend.model.Expense;
import com.smartspend.smartspend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;


@Controller
@RequestMapping("/web/expenses") // Access pages like /web/expenses/add
public class ExpenseWebController {

    @Autowired
    private ExpenseService expenseService;

    // Test to verify controller is loaded
    @PostConstruct
    public void init() {
        System.out.println("✅ ExpenseWebController loaded!");
    }

    // Show all expenses
    @GetMapping
    public String viewExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expense/view-expenses";
    }

    // Show add form
    @GetMapping("/add")
    public String showAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expense/add-expense";
    }

    // Submit new expense
    @PostMapping("/save")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        expenseService.createExpense(expense);
        return "redirect:/web/expenses";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditExpenseForm(@PathVariable String id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "expense/edit-expense";
    }

    // Submit updated expense
    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable String id, @ModelAttribute("expense") Expense expense) {
        expenseService.updateExpense(id, expense);
        return "redirect:/web/expenses";
    }

    // Delete expense
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return "redirect:/web/expenses";
    }
}
