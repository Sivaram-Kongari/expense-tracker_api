package com.expense.service;

import com.expense.dto.RegisterRequest;
import com.expense.model.User;

public interface UserService {

	User registerUser(RegisterRequest request);
}
