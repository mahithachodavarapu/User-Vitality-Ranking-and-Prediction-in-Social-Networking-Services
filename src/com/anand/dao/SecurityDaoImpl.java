package com.anand.dao;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.anand.bo.AccountBo;
import com.anand.dto.AccountDto;

public class SecurityDaoImpl implements SecurityDao {

	private final String SQL_COUNT_USER_ACCOUNT = "select count(*) from USER_ACCOUNT where EMAIL=?";
	private final String SQL_AUTH_USER_ACCOUNT = "select * from USER_ACCOUNT where EMAIL=? and PASSWORD=?";
	private final String SQL_SEARCH_USER = "select * from USER_ACCOUNT where EMAIL like ? OR  FULLNAME like ?";
	private final String SQL_USER = "select * from USER_ACCOUNT";
	private static final String SQL_FRIEND_REQUEST = "INSERT INTO FRIEND_REQUEST values(?,?,?,?)";
	private static final String SQL_GET_FRIEND_REQUEST_INFO = "Select FROM_USER, TO_USER, STATUS from FRIEND_REQUEST where FROM_USER=? OR TO_USER=?";
	private static final String SQL_GET_USERS_PROFILE = "select user_account.*, Frid from User_Account, Friend_Request where  ( Email=From_User or Email=To_user ) And EMAIL=?";
	private static final String SQL_GET_REQUEST_PROFILE = "select user_account.*, Frid from User_Account, Friend_Request where  (FROM_USER=EMAIL) and  STATUS=1 And To_user = ?";
	private static final String SQL_UPDATE_FRIEND_REQUEST = "UPDATE  FRIEND_REQUEST SET STATUS = ? WHERE FRID = ?";
	
	//private static final String SQL_ACCEPT_FRIEND_REQUEST = "update  FRIEND_REQUEST set STATUS=2 where (FROM_USER=? and TO_USER=?) or (FROM_USER=? and TO_USER=?)";

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public AccountBo authentication(final String path, AccountBo accountBo) {

		AccountBo accountBoo = jt.query(SQL_AUTH_USER_ACCOUNT, new Object[] {
				accountBo.getEmail().trim(), accountBo.getPassword().trim() },
				new ResultSetExtractor<AccountBo>() {

					@Override
					public AccountBo extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						AccountBo profile = new AccountBo();

						if (rs.next()) {
							profile.setSerialNumber(rs.getString(1));
							profile.setFullName(rs.getString(2));
							profile.setEmail(rs.getString(3));
							profile.setPhone(rs.getString(5));
							profile.setEducation(rs.getString(6));
							profile.setAddress(rs.getString(7));
							profile.setUserType(rs.getString(10));

							Blob b = rs.getBlob(8);
							String pidinstring = rs.getString(1);
							try {
								if (b != null) {
									byte b1[] = b.getBytes(1, (int) b.length());
									OutputStream fout = new FileOutputStream(
											path + "/" + pidinstring
													+ rs.getString(9));
									fout.write(b1);

									profile.setPicture(pidinstring
											+ rs.getString(9));
								}
							} catch (Exception e) {
								System.out.println(e);
							}
						}
						return profile;
					}
				});

		return accountBoo;

	}

	@Override
	public int checkUsernameAvailable(String email) {

		return jt.queryForInt(SQL_COUNT_USER_ACCOUNT, new Object[] { email
				.trim() });
	}

	@Override
	public List<AccountDto> searchFriends(final String path, String searchName,
			final String user) {
		final HashMap<String, Integer> hm = getFriendRelationStatus(user);
System.out.println(hm);
		List<AccountDto> userList = jt.query(SQL_SEARCH_USER, new Object[] {
				"%" + searchName.trim() + "%", "%" + searchName.trim() + "%" },
				new ResultSetExtractor<List<AccountDto>>() {

					@Override
					public List<AccountDto> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<AccountDto> friendList = new ArrayList<AccountDto>();

						while (rs.next()) {
							AccountDto profile = new AccountDto();
							profile.setSerialNumber(rs.getString(1));
							profile.setFullName(rs.getString(2));
							profile.setEmail(rs.getString(3));
							profile.setPhone(rs.getString(5));
							profile.setEducation(rs.getString(6));
							profile.setAddress(rs.getString(7));
							profile.setUserType(rs.getString(10));

							System.out.println(rs.getString(2));
							Blob b = rs.getBlob(8);
							String pidinstring = rs.getString(1);
							try {
								if (b != null) {
									byte b1[] = b.getBytes(1, (int) b.length());
									OutputStream fout = new FileOutputStream(
											path + "/" + pidinstring
													+ rs.getString(9));
									fout.write(b1);

									profile.setPicture(pidinstring
											+ rs.getString(9));
								}
							} catch (Exception e) {
								System.out.println(e);
							}

							if (!profile.getEmail().equalsIgnoreCase(user)) {
								if (hm.containsKey(profile.getEmail())) {
									int status = hm.get(profile.getEmail());
									if (status == 1) {
										profile.setUrl("#");
										profile
												.setButtonLevel("+ Friend request sent");
										friendList.add(profile);
									}
									if (status == 2) {
										profile.setUrl("#");
										profile.setButtonLevel("+ Friend");
										friendList.add(profile);
									}
								} else {
									profile.setUrl("friend-request.htm?userid="
											+ profile.getEmail()
											+ "&requestCode=1");
									profile
											.setButtonLevel("+ Send friend request");
									friendList.add(profile);
								}
							}

						}
						return friendList;
					}
				});

		return userList;
	}

	@Override
	public HashMap<String, Integer> getFriendRelationStatus(String user) {
		return jt.query(SQL_GET_FRIEND_REQUEST_INFO,
				new Object[] { user, user },
				new ResultSetExtractor<HashMap<String, Integer>>() {
					@Override
					public HashMap<String, Integer> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						HashMap<String, Integer> fshm = new HashMap<String, Integer>();

						while (rs.next()) {
							fshm.put(rs.getString(1), rs.getInt(3));
							fshm.put(rs.getString(2), rs.getInt(3));
						}
						return fshm;
					}
				});
	}

	@Override
	public int friendRequest(String serialNumber, String fromUser, String toUser) {
		return jt.update(SQL_FRIEND_REQUEST, serialNumber, fromUser, toUser, 1);
	}

	@Override
	public List<AccountDto> getUsersProfile(final String path, String condation) {
		String query = "";
		if (condation.contains("(")) {
			query = SQL_GET_USERS_PROFILE;
			condation=condation.replaceFirst("(", "");
		} else {
			query = SQL_GET_REQUEST_PROFILE;
		}
		condation=condation.trim();
		List<AccountDto> userList = jt.query(query,new Object[]{condation},
				new ResultSetExtractor<List<AccountDto>>() {

					@Override
					public List<AccountDto> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<AccountDto> friendList = new ArrayList<AccountDto>();

						while (rs.next()) {
							AccountDto profile = new AccountDto();
							profile.setSerialNumber(rs.getString(1));
							profile.setFullName(rs.getString(2));
							profile.setEmail(rs.getString(3));
							profile.setPhone(rs.getString(5));
							profile.setEducation(rs.getString(6));
							profile.setAddress(rs.getString(7));
							profile.setUserType(rs.getString(10));

							System.out.println(rs.getString(2));
							Blob b = rs.getBlob(8);
							String pidinstring = rs.getString(1);
							try {
								if (b != null) {
									byte b1[] = b.getBytes(1, (int) b.length());
									OutputStream fout = new FileOutputStream(
											path + "/" + pidinstring
													+ rs.getString(9));
									fout.write(b1);

									profile.setPicture(pidinstring
											+ rs.getString(9));
								}
							} catch (Exception e) {
								System.out.println(e);
							}

							profile.setSerialNumber(rs.getString(12));
							friendList.add(profile);
						}
						return friendList;
					}
				});
		return userList;
	}

	@Override
	public int acceptFriendRequest(String frid) {
		return jt.update(SQL_UPDATE_FRIEND_REQUEST, new Object[] { 2,
				frid.trim() });
		
		/*return jt.update(SQL_ACCEPT_FRIEND_REQUEST, new Object[] {from.trim(),
				to.trim(),
				to.trim(),from.trim() });
		*/
		
	}

	@Override
	public int unfriend(String fromUser, String toUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccountDto> getMyFriendProfile(final String path, final String user) {

		final HashMap<String, Integer> hm = getFriendRelationStatus(user);
		System.out.println(hm);
				List<AccountDto> userList = jt.query(SQL_USER,
						new ResultSetExtractor<List<AccountDto>>() {

							@Override
							public List<AccountDto> extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								List<AccountDto> friendList = new ArrayList<AccountDto>();

								while (rs.next()) {
									AccountDto profile = new AccountDto();
									profile.setSerialNumber(rs.getString(1));
									profile.setFullName(rs.getString(2));
									profile.setEmail(rs.getString(3));
									profile.setPhone(rs.getString(5));
									profile.setEducation(rs.getString(6));
									profile.setAddress(rs.getString(7));
									profile.setUserType(rs.getString(10));

									System.out.println(rs.getString(2));
									Blob b = rs.getBlob(8);
									String pidinstring = rs.getString(1);
									try {
										if (b != null) {
											byte b1[] = b.getBytes(1, (int) b.length());
											OutputStream fout = new FileOutputStream(
													path + "/" + pidinstring
															+ rs.getString(9));
											fout.write(b1);

											profile.setPicture(pidinstring
													+ rs.getString(9));
										}
									} catch (Exception e) {
										System.out.println(e);
									}

									if (!profile.getEmail().equalsIgnoreCase(user)) {
										if (hm.containsKey(profile.getEmail())) {
											int status = hm.get(profile.getEmail());
											
											if (status == 2) {
												profile.setUrl("#");
												profile.setButtonLevel("+ Friend");
												friendList.add(profile);
											}
										} 
									}

								}
								return friendList;
							}
						});

				return userList;
	}



}
