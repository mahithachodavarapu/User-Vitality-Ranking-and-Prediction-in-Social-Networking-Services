package com.anand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anand.service.MessageService;

public class ReadMessageController  extends AbstractController {
	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		session.setAttribute("MID",request.getParameter("mid"));
		messageService.changeStatus(request.getParameter("mid"), "1");
		return new ModelAndView("read-message");
	}
}
