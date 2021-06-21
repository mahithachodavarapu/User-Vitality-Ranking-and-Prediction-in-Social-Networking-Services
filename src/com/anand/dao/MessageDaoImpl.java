package com.anand.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.anand.dto.MessageDto;

public class MessageDaoImpl implements MessageDao {

	private JdbcTemplate jt;
	private static final String SQL_SEND_MESSAGE = "INSERT INTO MESSAGE values(?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE_MESSAGE_STATUS = "UPDATE  MESSAGE SET STATUS = ? WHERE MID = ?";
	private static final String SQL_INBOX_MESSAGE = "SELECT * FROM MESSAGE where TO_USER=?";

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int sendMessage(MessageDto mdto) {
		return jt.update(SQL_SEND_MESSAGE, mdto.getSerialID().trim(), mdto
				.getFromEmail().trim(), mdto.getToEmail().trim(), mdto
				.getSubject().trim(), mdto.getMessage().trim(), mdto
				.getPostDate(), "0");
	}

	@Override
	public Map<String, MessageDto> getInboxMessage(String toEmail) {

		Map<String, MessageDto> inbox = jt.query(SQL_INBOX_MESSAGE,
				new Object[] { toEmail.trim() },
				new ResultSetExtractor<Map<String, MessageDto>>() {

					@Override
					public Map<String, MessageDto> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Map<String, MessageDto> hm = new HashMap<String, MessageDto>();
						while (rs.next()) {
							MessageDto dto = new MessageDto();
							dto.setSerialID(rs.getString(1));
							dto.setFromEmail(rs.getString(2));
							dto.setSubject(rs.getString(4));
							dto.setMessage(rs.getString(5));
							dto.setPostDate(rs.getString(6).substring(0,11).trim());
							dto.setStatus(rs.getString(7));

							hm.put(dto.getSerialID(), dto);
						}
						return hm;
					}
				});

		return inbox;
	}

	@Override
	public int changeStatus(String mid, String statusCode) {
		return jt.update(SQL_UPDATE_MESSAGE_STATUS,statusCode,mid);
	}

}
