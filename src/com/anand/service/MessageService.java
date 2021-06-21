package com.anand.service;

import java.util.Map;

import com.anand.bo.MessageBo;
import com.anand.dto.MessageDto;


public interface MessageService {
	String sendMessage(MessageBo bo);
	Map<String, MessageDto> getInboxMessage(String toEmail);
	String changeStatus(String mid,String statusCode);
}
