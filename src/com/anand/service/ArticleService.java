package com.anand.service;

import java.util.List;

import com.anand.dto.ArticleDto;

public interface ArticleService {

	String postArticle(ArticleDto articleDto);
	String likeArticle(ArticleDto articleDto);
	List<ArticleDto> getArticles();
}
