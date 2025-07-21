package com.expense.repository;

import java.time.LocalDate;
import java.util.List;
import com.expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import com.expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	// Custom method to filter expenses by category
	List<Expense> findByCategory(Category category);

	//filter by date range
	List<Expense> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);

	//filter by category and date range
	List<Expense> findByCategoryAndExpenseDateBetween(Category category, LocalDate starDate, LocalDate endDate);
}
