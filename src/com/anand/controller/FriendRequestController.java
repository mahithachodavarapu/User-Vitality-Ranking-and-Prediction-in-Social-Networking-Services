package com.anand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anand.dto.AccountDto;
import com.anand.service.SearchFriendsService;

public class FriendRequestController extends AbstractController {

	SearchFriendsService searchFriendsService;

	public void setSearchFriendsService(
			SearchFriendsService searchFriendsService) {
		this.searchFriendsService = searchFriendsService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		AccountDto accountDto = (AccountDto) session
				.getAttribute("USERPROFILE");
		String toUser = request.getParameter("userid").trim();
		String requestCode = request.getParameter("requestCode").trim();
		String fromUser = accountDto.getEmail();
		System.out.println(toUser + requestCode);
		String frid = request.getParameter("frid");
		if(frid!=null){
			fromUser=frid;
		}
		return new ModelAndView("success-page", "resMsg", searchFriendsService
				.friendService(fromUser, toUser, requestCode));

	}

}
