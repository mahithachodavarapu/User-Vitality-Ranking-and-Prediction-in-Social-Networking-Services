package com.anand.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.anand.command.LoginCommand;

public class LoginCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> classType) {
		if (classType.isAssignableFrom(LoginCommand.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object command, Errors errors) {
		LoginCommand loginCommand = null;
		loginCommand = (LoginCommand) command;

		if (loginCommand.getEmail() == null
				|| "".equals(loginCommand.getEmail().trim())) {
			errors.rejectValue("email", "email.blank");
		}

		if (loginCommand.getPassword() == null
				|| "".equals(loginCommand.getPassword())) {
			errors.rejectValue("password", "password.blank");
		}

	}

}