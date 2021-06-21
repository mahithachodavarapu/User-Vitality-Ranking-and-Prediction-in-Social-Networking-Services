package com.anand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.anand.bo.MessageBo;
import com.anand.service.MessageService;

@SuppressWarnings("deprecation")
public class MessageController extends SimpleFormController {
	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		MessageBo bo = new MessageBo();
		bo.setFromEmail(request.getParameter("fromEmail"));
		bo.setToEmail(request.getParameter("toEmail"));
		bo.setSubject(request.getParameter("subject"));
		bo.setMessage(request.getParameter("message"));

		return new ModelAndView("send-message", "resMsg", messageService
				.sendMessage(bo));
	}
}
