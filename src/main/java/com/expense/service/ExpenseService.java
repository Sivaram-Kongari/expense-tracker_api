package com.expense.service;

import java.time.LocalDate;
import java.util.List;
import com.expense.model.Category;
import com.expense.model.Expense;

public interface ExpenseService {

	Expense createExpense(Expense expense);
	List<Expense> getAllExpenses();
	Expense getExpenseById(Long id);
	Expense updateExpense(Long id, Expense updatedExpense);
	void deleteExpense(Long id);
	List<Expense> filterByCategory(Category category);
	List<Expense> filterByDateRange(LocalDate startDate, LocalDate endDate);
	List<Expense> filterByCategoryAndDate(Category category, LocalDate startDate, LocalDate endDate);

}
