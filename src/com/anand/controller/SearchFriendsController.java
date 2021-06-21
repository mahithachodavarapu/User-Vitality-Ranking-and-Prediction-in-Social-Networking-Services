package com.anand.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anand.dto.AccountDto;
import com.anand.service.SearchFriendsService;

public class SearchFriendsController extends AbstractController {

	SearchFriendsService searchFriendsService;

	public void setSearchFriendsService(
			SearchFriendsService searchFriendsService) {
		this.searchFriendsService = searchFriendsService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		String path = context.getRealPath("/images");
		String searchName = request.getParameter("searchName");

		AccountDto accountDto = (AccountDto) session
				.getAttribute("USERPROFILE");

		return new ModelAndView("search-friend-list", "userList",
				searchFriendsService.searchFriends(path, searchName , accountDto.getEmail()));
	}

}
