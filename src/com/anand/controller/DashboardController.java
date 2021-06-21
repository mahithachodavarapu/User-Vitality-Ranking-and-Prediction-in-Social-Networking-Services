package com.anand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anand.service.DashboardService;

public class DashboardController  extends AbstractController {

	DashboardService dashboardService;

	public void setDashboardService(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		try {
			if (session.getAttribute("GROUPMEMBERS") == null) {
				session.setAttribute("GROUPMEMBERS", dashboardService
						.getGroupMembers());
			}

			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			
			System.out.println(fromDate+toDate);

			if (session.getAttribute("GROUPINTRACTION") == null
					&& (toDate != null && fromDate != null)) {
				session.setAttribute("GROUPINTRACTION", dashboardService
						.getGroupInteraction(fromDate, toDate));
			}
			
			

			if (session.getAttribute("GROUPINTRACTIONPrevious") == null
					&& (toDate != null && fromDate != null)) {
			
				if(page.equalsIgnoreCase("ri-intraction")||page.equalsIgnoreCase("user-vitality-score")){
					toDate=fromDate;
					fromDate="1960-01-01";
				session.setAttribute("GROUPINTRACTIONPrevious", dashboardService
						.getGroupInteraction(fromDate, toDate));
				}
			}

			request.setAttribute("timeperiod", fromDate+" to "+toDate);
			//request.setAttribute("fromDate", fromDate);
		//	request.setAttribute("toDate", toDate);
			
			
		} catch (Exception e) {
System.out.println(e);
		}
		return new ModelAndView(page);
	}
}
