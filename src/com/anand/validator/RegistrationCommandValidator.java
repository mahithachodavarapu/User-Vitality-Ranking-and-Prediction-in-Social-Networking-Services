package com.anand.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.anand.command.RegistrationCommand;

public class RegistrationCommandValidator implements Validator {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
	    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	@Override
	public boolean supports(Class<?> classType) {
		if (classType.isAssignableFrom(RegistrationCommand.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object command, Errors errors) {
		RegistrationCommand registrationCommand = null;
		registrationCommand = (RegistrationCommand) command;

		if (registrationCommand.getFullName() == null
				|| "".equals(registrationCommand.getFullName().trim())) {
			errors.rejectValue("fullName", "fullName.blank");
		}

		if (registrationCommand.getEmail() == null
				|| "".equals(registrationCommand.getEmail().trim())) {
			errors.rejectValue("email", "email.blank");
		}

		if (registrationCommand.getPassword() == null
				|| "".equals(registrationCommand.getPassword())) {
			errors.rejectValue("password", "password.blank");
		} else if (registrationCommand.getPassword().length() < 6) {
			errors.rejectValue("password", "password.length");
		}

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(registrationCommand.getEmail());
        
		if (!matcher.find()) {			
			errors.rejectValue("email", "email.format");
		}
		
	}

}
