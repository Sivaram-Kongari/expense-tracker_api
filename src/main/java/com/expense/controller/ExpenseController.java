package com.expense.controller;

import java.time.LocalDate;
import java.util.List;
import com.expense.model.Category;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.expense.model.Expense;
import com.expense.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseService expenseService;

	@PostMapping
	public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) {

		return ResponseEntity.ok(expenseService.createExpense(expense));
	}

	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {

		return ResponseEntity.ok(expenseService.getAllExpenses());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {

		return ResponseEntity.ok(expenseService.getExpenseById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long id, 
			@Valid @RequestBody Expense expense) {

		return ResponseEntity.ok(expenseService.updateExpense(id, expense));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable Long id) {

		expenseService.deleteExpense(id);
		return ResponseEntity.ok("Expense deleted successfully.......");
	}

	@GetMapping("/filter/category")
	public ResponseEntity<List<Expense>> getByCategory(@RequestParam Category category) {

		return ResponseEntity.ok(expenseService.filterByCategory(category));
	}

	@GetMapping("/filter/date")
	public ResponseEntity<List<Expense>> getByDateRange(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

		return ResponseEntity.ok(expenseService.filterByDateRange(startDate, endDate));
	}

	@GetMapping("/filter/category-date")
	public ResponseEntity<List<Expense>> getByCategoryAndDate(
			@RequestParam Category category,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

		return ResponseEntity.ok(expenseService.filterByCategoryAndDate(category, startDate, endDate));
	}
}