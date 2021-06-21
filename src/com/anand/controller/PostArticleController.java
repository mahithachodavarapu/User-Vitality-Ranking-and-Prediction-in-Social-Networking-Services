package com.anand.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.anand.dto.AccountDto;
import com.anand.dto.ArticleDto;
import com.anand.service.ArticleService;

@SuppressWarnings("deprecation")
public class PostArticleController extends SimpleFormController {
	private ArticleService articleService;

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		HttpSession session = request.getSession();
		
		AccountDto accountDto=(AccountDto)session.getAttribute("USERPROFILE");
		ArticleDto articleDto;
		articleDto = new ArticleDto();
		
		articleDto.setEmail(accountDto.getEmail());
		articleDto.setArticleHead(request.getParameter("articleHead"));
		articleDto.setArticleBody(request.getParameter("articleBody"));
		
		
		return new ModelAndView("post-article", "resMsg",articleService.postArticle(articleDto));
		/*accountDto=accountService.authentication(path,accountDto);
		userType=accountDto.getUserType();
		if (userType==null||"".equals(userType)) {
			return new ModelAndView("login", "resMsg","Invalid credentials!!");
		} else {
			session = request.getSession();
			session.setAttribute("USER", userType);
			session.setAttribute("USERPROFILE", accountDto);
			String page=null;
			if (userType.equals("ADMIN")) {
				page="user-home";
			} else if (userType.equals("USER")) {
				page="user-home";
			}
			System.out.println(page+userType);
			return new ModelAndView(page);
		}*/
		
		
	}
}
