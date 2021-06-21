package com.anand.service;


import java.util.Map;

import com.anand.dto.AccountDto;
import com.anand.exception.RegistrationException;

public interface AccountService {

	AccountDto authentication(String path,AccountDto accountDto);

	Map<String, Integer> getFriendList(String user);
	String changePassword(AccountDto accountDto);

	boolean checkUsernameAvailable(String email);

	String register(AccountDto accountDto)throws RegistrationException;
}
