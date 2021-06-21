package com.anand.service;

import java.util.Map;

import com.anand.bo.AccountBo;
import com.anand.dao.RegistrationDao;
import com.anand.dao.SecurityDao;
import com.anand.dto.AccountDto;
import com.anand.util.Utility;

public class AccountServiceImpl implements AccountService {

	private RegistrationDao registrationDao;
	private SecurityDao securityDao;
	private Utility utility;

	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	@Override
	public AccountDto authentication(String path, AccountDto accountDto) {
		AccountBo accountBo = new AccountBo();
		accountBo.setEmail(accountDto.getEmail());
		accountBo.setPassword(accountDto.getPassword());

		try {
			accountBo = securityDao.authentication(path, accountBo);

			accountDto.setSerialNumber(accountBo.getSerialNumber());
			accountDto.setFullName(accountBo.getFullName());
			accountDto.setEmail(accountBo.getEmail());
			accountDto.setPhone(accountBo.getPhone());
			accountDto.setEducation(accountBo.getEducation());
			accountDto.setAddress(accountBo.getAddress());
			accountDto.setUserType(accountBo.getUserType());
			accountDto.setPicture(accountBo.getPicture());

		} catch (Exception e) {

		}
		return accountDto;

	}

	@Override
	public String changePassword(AccountDto registerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUsernameAvailable(String email) {
		if (securityDao.checkUsernameAvailable(email) > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String register(AccountDto accountDto) {
		AccountBo accountBo = null;
		String message;
		if (checkUsernameAvailable(accountDto.getEmail())) {
			accountBo = new AccountBo();
			try {
				accountBo.setFullName(accountDto.getFullName());
				accountBo.setEmail(accountDto.getEmail());
				accountBo.setPassword(accountDto.getPassword());
				accountBo.setPhone(accountDto.getPhone());
				accountBo.setEducation(accountDto.getEducation());
				accountBo.setAddress(accountDto.getAddress());
				accountBo.setPicture(accountDto.getPicture());
				accountBo.setPictureExtensions(accountDto
						.getPictureExtensions());
				accountBo.setSerialNumber(utility.generateSerialNumber());
				accountBo.setRegistrationDate(utility.getCurrentDate());
				accountBo.setUserType("USER");
				if (registrationDao.register(accountBo) > 0) {
					message = "Your account has been created successfully. <br/> Welcome to UVRPSNS!";
				} else {
					message = "Sorry an unexpected error occurred please try again later.";
				}
			} catch (Exception e) {
				System.out.println(e);
				message = "Sorry an unexpected error occurred please try again later.";
			}
			System.out.println(message);
			return message;
		} else {
			System.out
					.println("Please try again with a different email address");
			return "Please try again with a different email address";
		}

	}

	@Override
	public Map<String, Integer> getFriendList(String user) {
		return securityDao.getFriendRelationStatus(user);
	}

}
