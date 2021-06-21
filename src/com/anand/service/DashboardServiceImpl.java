package com.anand.service;

import java.util.Map;
import java.util.Set;

import com.anand.dao.DashboardDao;
import com.anand.util.Utility;

public class DashboardServiceImpl implements DashboardService {
	private Utility utility;
	private DashboardDao dashboardDao;
	public void setUtility(Utility utility) {
		this.utility = utility;
	}
	public void setDashboardDao(DashboardDao dashboardDao) {
		this.dashboardDao = dashboardDao;
	}
	@Override
	public Map<String, Set<String>> getGroupMembers() {		
		
		return dashboardDao.getGroupMembers();
	}
	@Override
	public Map<String, Integer> getGroupInteraction(String fromDate,String toDate) {
		return dashboardDao.getGroupInteraction(fromDate, toDate);
	}
	

}
