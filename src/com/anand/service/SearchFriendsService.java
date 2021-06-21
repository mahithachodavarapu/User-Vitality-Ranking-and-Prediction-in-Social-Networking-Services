package com.anand.service;

import java.util.List;

import com.anand.dto.AccountDto;


public interface SearchFriendsService {

	List<AccountDto> searchFriends(String path,String searchName,String user);
	
	List<AccountDto> getFriendRequest(String path,String user);
	List<AccountDto> getFriendList(String path,String user);
	String friendService(String fromUser,String toUser,String requestCode);
	

	List<AccountDto> getMyFriendProfile(String path, String user);
}