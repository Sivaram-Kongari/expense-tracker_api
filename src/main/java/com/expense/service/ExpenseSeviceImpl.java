package com.expense.service;

import java.time.LocalDate;
import java.util.List;
import com.expense.model.Category;
import org.springframework.stereotype.Service;
import com.expense.model.Expense;
import com.expense.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseSeviceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepository;

	@Override
	public Expense createExpense(Expense expense) {

		return expenseRepository.save(expense);
	}

	@Override
	public List<Expense> getAllExpenses() {

		return expenseRepository.findAll();

	}

	@Override
	public Expense getExpenseById(Long id) {

		return expenseRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Exception not found with id : "+id));
	}

	@Override
	public Expense updateExpense(Long id, Expense updatedExpense) {

		Expense existingExpense = getExpenseById(id);

		existingExpense.setTitle(updatedExpense.getTitle());
		existingExpense.setAmount(updatedExpense.getAmount());
		existingExpense.setCategory(updatedExpense.getCategory());
		existingExpense.setExpenseDate(updatedExpense.getExpenseDate());

		return expenseRepository.save(existingExpense);
	}

	@Override
	public void deleteExpense(Long id) {

		Expense expense = getExpenseById(id);
		expenseRepository.delete(expense);	
	}

	@Override
	public List<Expense> filterByCategory(Category category) {

		return expenseRepository.findByCategory(category);
	}

	@Override
	public List<Expense> filterByDateRange(LocalDate startDate, LocalDate endDate) {

		return expenseRepository.findByExpenseDateBetween(startDate, endDate);
	}

	@Override
	public List<Expense> filterByCategoryAndDate(Category category, LocalDate startDate, LocalDate endDate) {

		return expenseRepository.findByCategoryAndExpenseDateBetween(category, startDate, endDate);
	}

}
