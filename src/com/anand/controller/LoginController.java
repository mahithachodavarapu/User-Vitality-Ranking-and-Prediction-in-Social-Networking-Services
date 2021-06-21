package com.anand.controller;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.anand.dto.AccountDto;
import com.anand.service.AccountService;
import com.anand.service.ArticleService;

@SuppressWarnings("deprecation")
public class LoginController extends SimpleFormController {
	private AccountService accountService;
	private ArticleService articleService;

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		String path = context.getRealPath("/images");
		
		
		AccountDto accountDto;
		accountDto = new AccountDto();
		
		accountDto.setEmail(request.getParameter("email"));
		accountDto.setPassword(request.getParameter("password"));
		
		
		
		request.getSession();
		String userType =null;
		
		
		accountDto=accountService.authentication(path,accountDto);
		userType=accountDto.getUserType();
		if (userType==null||"".equals(userType)) {
			return new ModelAndView("login", "resMsg","Invalid credentials!!");
		} else {
			session = request.getSession();
			session.setAttribute("USER", userType);
			session.setAttribute("USEREMAIL", request.getParameter("email"));
			session.setAttribute("USERPROFILE", accountDto);
			// get all my friend
			


			session.setAttribute("MYFRIENDLIST",accountService.getFriendList(request.getParameter("email")));
			
			String page=null;
			if (userType.equals("ADMIN")) {
				page="admin-home";
			} else if (userType.equals("USER")) {

				session.setAttribute("ARTICILES", articleService.getArticles());
				page="user-home";
			}
			System.out.println(page+userType);
			return new ModelAndView(page);
		}
	}
}
