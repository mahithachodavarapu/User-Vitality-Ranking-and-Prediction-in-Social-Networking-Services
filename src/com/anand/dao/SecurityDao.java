package com.anand.dao;

import java.util.HashMap;
import java.util.List;

import com.anand.bo.AccountBo;
import com.anand.dto.AccountDto;

public interface SecurityDao {
	int checkUsernameAvailable(String email);

	public AccountBo authentication(String path, AccountBo accountBo);

	List<AccountDto> searchFriends(String path, String searchName,
			final String user);

	int friendRequest(String serialNumber, String fromUser, String toUser);

	public int acceptFriendRequest(String fid);

	int unfriend(String fromUser, String toUser);

	List<AccountDto> getUsersProfile(String path, String condation);
	List<AccountDto> getMyFriendProfile(String path, String user);

	HashMap<String, Integer> getFriendRelationStatus(String user);


}
