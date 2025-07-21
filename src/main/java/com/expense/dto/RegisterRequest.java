package com.expense.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

	@Email(message = "Invalid email")
	@NotBlank(message = "Email is required")
	private String email;

	private String password;

}
