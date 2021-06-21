package com.anand.service;

import java.util.Map;
import java.util.Set;

public interface DashboardService {
	Map<String,Set<String>> getGroupMembers();
	Map<String,Integer> getGroupInteraction(String fromDate,String toDate);
}
