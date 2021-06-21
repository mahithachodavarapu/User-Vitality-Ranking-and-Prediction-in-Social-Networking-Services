package com.anand.dao;

import java.util.Map;

import com.anand.dto.MessageDto;

public interface MessageDao {
	int sendMessage(MessageDto mdto);

	Map<String, MessageDto> getInboxMessage(String toEmail);

	int changeStatus(String mid,String statusCode);
}
