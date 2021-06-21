package com.anand.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.anand.dao.SecurityDao;
import com.anand.dto.AccountDto;
import com.anand.util.Utility;

public class SearchFriendsServiceImpl implements SearchFriendsService {
	private Utility utility;
	SecurityDao securityDao;

	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	@Override
	public List<AccountDto> searchFriends(String path, String searchName,
			String user) {

		return securityDao.searchFriends(path, searchName, user);
	}

	@Override
	public String friendService(String fromUser, String toUser,
			String requestCode) {

		String status = "Sorry something went wrong please try again";

		if ("1".equalsIgnoreCase(requestCode)) {
			if (securityDao.friendRequest(utility.generateSerialNumber(),
					fromUser, toUser) > 0) {
				status = "friend request sent successfully";
			}
		} else if ("2".equalsIgnoreCase(requestCode)) {

			// here fromUser value is frid not user email
			String frid = fromUser;
			if (securityDao.acceptFriendRequest(frid) > 0) {
				status = "you're now friends with " + toUser;
			}
		} else if ("3".equalsIgnoreCase(requestCode)) {
			if (securityDao.unfriend(fromUser, toUser) > 0) {
				status = "unfriend";
			}
		}
		return status;
	}

	@Override
	public List<AccountDto> getFriendList(String path, String user) {
		HashMap<String, Integer> frs = securityDao
				.getFriendRelationStatus(user);
		
		
		String condation = " Email IN (";
		Iterator<String> itr = frs.keySet().iterator();
		int i = 0;
		if (frs.size() >= 1) {
			while (itr.hasNext()) {
				String email = (String) itr.next();
				if (frs.get(email) == 2 && (!email.equalsIgnoreCase(user))) {
					i = i + 1;
					condation = condation + "'" + email + "',";

				}
			}
			condation = condation.trim();
			if (condation.endsWith(",")) {
				condation = condation.substring(0, condation.length() - 1);
				System.out.println(condation);
			}
			condation = condation + ")";
		}
		System.out.println(condation);
		if (i == 0) {
			return null;
		} else {
			return securityDao.getUsersProfile(path, condation);
		}
	}

	@Override
	public List<AccountDto> getFriendRequest(String path, String user) {

		
			return securityDao.getUsersProfile(path, user);
	

	}

	@Override
	public List<AccountDto> getMyFriendProfile(String path, String user) {
		return securityDao.getMyFriendProfile(path, user);
	}


}
