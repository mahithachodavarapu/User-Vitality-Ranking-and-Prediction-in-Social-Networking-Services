package com.anand.service;

import java.text.ParseException;
import java.util.Map;

import com.anand.bo.MessageBo;
import com.anand.dao.MessageDao;
import com.anand.dto.MessageDto;
import com.anand.util.Utility;

public class MessageServiceImpl implements MessageService {

	private Utility utility;
	private MessageDao messageDao;

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public String sendMessage(MessageBo bo) {
		MessageDto dto = new MessageDto();
		// utility.generateSerialNumber();
		// write code to convert
		dto.setFromEmail(bo.getFromEmail());
		dto.setToEmail(bo.getToEmail());
		dto.setSubject(bo.getSubject());
		dto.setMessage(bo.getMessage());
		dto.setSerialID(utility.generateSerialNumber());
		try {
			dto.setPostDate(utility.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return (messageDao.sendMessage(dto)>0?"message has been sent successfully":"delivery failed");
	}

	@Override
	public Map<String, MessageDto> getInboxMessage(String toEmail) {
		
		return messageDao.getInboxMessage(toEmail);
	}

	@Override
	public String changeStatus(String mid, String statusCode) {
		return (messageDao.changeStatus(mid, statusCode)>0?"1":"0");
	}

}
