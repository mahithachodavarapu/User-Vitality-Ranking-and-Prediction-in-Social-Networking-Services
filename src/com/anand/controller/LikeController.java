package com.anand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anand.dto.ArticleDto;
import com.anand.service.ArticleService;

public class LikeController extends AbstractController {
	private ArticleService articleService;

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArticleDto articleDto = null;
		articleDto = new ArticleDto();
		
		articleDto.setReader(request.getParameter("reader"));
		articleDto.setAuthor(request.getParameter("author"));
		articleDto.setArticleSerialNumber(request.getParameter("aid"));
		
		

		return new ModelAndView("user-home", "likeMsg",articleService.likeArticle(articleDto));
	}
}