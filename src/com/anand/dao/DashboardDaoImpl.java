package com.anand.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class DashboardDaoImpl implements DashboardDao {
	private JdbcTemplate jt;
	private static final String SQL_GET_FRIENDS_EMAIL = "Select FROM_USER, TO_USER from FRIEND_REQUEST where (FROM_USER = ? and STATUS = '2' ) OR ( TO_USER = ?  and STATUS = '2' )";
	private static final String SQL_GET_ALL_USER_EMAIL = "Select EMAIL from USER_ACCOUNT";
	// private static final String SQL_COUNT_MSG_INTRACTION =
	// "SELECT count(*) FROM MESSAGE WHERE (FROM_USER = ? or TO_USER=?) and MEG_DATE BETWEEN TO_DATE (?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd')";
	// private static final String SQL_COUNT_LIKE_INTRACTION =
	// "SELECT count(*) FROM LIKES WHERE (AUTHOR = ? or READER=?) and LIKE_DATE BETWEEN TO_DATE (?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd')";

	private static final String SQL_COUNT_INTRACTION = "select appuser, Sum(intraction) from((select appuser, Sum(ANo) as intraction  from (  select AUTHOR as appuser, count(AUTHOR) as ANo from LIKES Where LIKE_DATE BETWEEN TO_DATE (?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd') Group by AUTHOR union select READER as appuser,  count(READER) ANo  from LIKES Where LIKE_DATE BETWEEN TO_DATE (?, 'yyyy-mm-dd')   AND TO_DATE (?, 'yyyy-mm-dd') Group by READER) group by appuser) union (select From_user, Sum(lNo) as intraction from (  select From_user, count(from_user) as lNo from message Where MEG_DATE BETWEEN TO_DATE (?, 'yyyy-mm-dd')   AND TO_DATE (?, 'yyyy-mm-dd') Group by from_user  union  select to_user,  count(to_user) lNo from message Where MEG_DATE BETWEEN TO_DATE (?, 'yyyy-mm-dd')  AND TO_DATE (?, 'yyyy-mm-dd') Group by to_user)  group by From_user)) group by appuser";

	/*
	 * 
	 * select From_user, Sum(No) from ( select From_user, count(from_user) as No
	 * from message Where MEG_DATE BETWEEN TO_DATE ('2017-07-01', 'yyyy-mm-dd')
	 * AND TO_DATE ('2017-07-07', 'yyyy-mm-dd') Group by from_user
	 * 
	 * union select to_user, count(to_user) No from message Where MEG_DATE
	 * BETWEEN TO_DATE ('2017-07-01', 'yyyy-mm-dd') AND TO_DATE ('2017-07-07',
	 * 'yyyy-mm-dd') Group by to_user) group by From_user;
	 */

	/*
	 * final query to get intration
	 * 
	 * 
	 * select appuser, Sum(intraction) from(
	 * 
	 * (select appuser, Sum(ANo) as intraction from ( select AUTHOR as appuser,
	 * count(AUTHOR) as ANo from LIKES Where LIKE_DATE BETWEEN TO_DATE
	 * ('2017-07-01', 'yyyy-mm-dd') AND TO_DATE ('2017-07-07', 'yyyy-mm-dd')
	 * Group by AUTHOR
	 * 
	 * union select READER as appuser, count(READER) ANo from LIKES Where
	 * LIKE_DATE BETWEEN TO_DATE ('2017-07-01', 'yyyy-mm-dd') AND TO_DATE
	 * ('2017-07-07', 'yyyy-mm-dd') Group by READER) group by appuser)
	 * 
	 * union
	 * 
	 * (select From_user, Sum(lNo) as intraction from ( select From_user,
	 * count(from_user) as lNo from message Where MEG_DATE BETWEEN TO_DATE
	 * ('2017-07-01', 'yyyy-mm-dd') AND TO_DATE ('2017-07-07', 'yyyy-mm-dd')
	 * Group by from_user
	 * 
	 * union select to_user, count(to_user) lNo from message Where MEG_DATE
	 * BETWEEN TO_DATE ('2017-07-01', 'yyyy-mm-dd') AND TO_DATE ('2017-07-07',
	 * 'yyyy-mm-dd') Group by to_user) group by From_user)) group by appuser;
	 */
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public Map<String, Set<String>> getGroupMembers() {
		List<String> users = jt.queryForList(SQL_GET_ALL_USER_EMAIL,
				String.class);
		System.out.println(users);
		Map<String, Set<String>> groups = new HashMap<String, Set<String>>();
		for (String user : users) {
			groups.put(user, jt.query(SQL_GET_FRIENDS_EMAIL, new Object[] {
					user, user }, new ResultSetExtractor<Set<String>>() {
				@Override
				public Set<String> extractData(ResultSet rs)
						throws SQLException, DataAccessException {
					Set<String> emails = new HashSet<String>();
					while (rs.next()) {
						emails.add(rs.getString(1));
						emails.add(rs.getString(2));
					}
					return emails;
				}
			}));
		}

		return groups;
	}

	@Override
	public Map<String, Integer> getGroupInteraction(String fromDate,
			String toDate) {
		return jt.query(SQL_COUNT_INTRACTION, new Object[] { fromDate.trim(),
				toDate.trim(), fromDate.trim(), toDate.trim(), fromDate.trim(),
				toDate.trim(), fromDate.trim(), toDate.trim(), },
				new ResultSetExtractor<Map<String, Integer>>() {
					@Override
					public Map<String, Integer> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Map<String, Integer> groupsInteraction = new HashMap<String, Integer>();
						while (rs.next()) {
							groupsInteraction
									.put(rs.getString(1), rs.getInt(2));
						}
						return groupsInteraction;
					}
				});
	}
}
