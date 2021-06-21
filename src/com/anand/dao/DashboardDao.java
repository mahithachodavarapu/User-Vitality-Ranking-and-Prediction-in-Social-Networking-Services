package com.anand.dao;

import java.util.Map;
import java.util.Set;

public interface DashboardDao {
	Map<String,Set<String>> getGroupMembers();

	Map<String,Integer> getGroupInteraction(String fromDate,String toDate);
}
