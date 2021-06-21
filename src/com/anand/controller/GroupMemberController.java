package com.anand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anand.service.DashboardService;

public class GroupMemberController extends AbstractController {

	DashboardService dashboardService;

	public void setDashboardService(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("GROUPMEMBERS", dashboardService.getGroupMembers());
		return new ModelAndView("view-group-memeber");
	}
}