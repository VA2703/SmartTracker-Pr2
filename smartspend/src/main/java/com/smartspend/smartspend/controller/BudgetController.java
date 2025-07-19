package com.smartspend.smartspend.controller;

import com.smartspend.smartspend.model.Budget;
import com.smartspend.smartspend.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // ✅ Show all budgets (uses: view-budget.html)
    @GetMapping
    public String viewBudgets(Model model) {
        List<Budget> budgets = budgetService.getAllBudgets();
        model.addAttribute("budgets", budgets);
        return "budget/view-budget";
    }

    // ✅ Show form to set a new budget (uses: set-budget.html)
    @GetMapping("/new")
    public String showBudgetForm(Model model) {
        model.addAttribute("budget", new Budget());
        return "budget/set-budget";
    }

    // ✅ Handle form submission to save budget
    @PostMapping("/save")
    public String saveBudget(@ModelAttribute("budget") Budget budget) {
        budgetService.saveBudget(budget);
        return "redirect:/budget";
    }

    // ✅ Edit budget (optional: reuse set-budget.html)
    @GetMapping("/edit/{id}")
    public String editBudget(@PathVariable String id, Model model) {
        Budget budget = budgetService.getBudgetById(id);
        model.addAttribute("budget", budget);
        return "budget/set-budget";
    }

    // ✅ Delete budget
    @GetMapping("/delete/{id}")
    public String deleteBudget(@PathVariable String id) {
        budgetService.deleteBudget(id);
        return "redirect:/budget";
    }
}
