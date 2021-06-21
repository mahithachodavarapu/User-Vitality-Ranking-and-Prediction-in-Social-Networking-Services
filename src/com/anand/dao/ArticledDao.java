package com.anand.dao;

import java.util.List;

import com.anand.bo.ArticleBo;
import com.anand.dto.ArticleDto;

public interface ArticledDao {
	int postArticle(ArticleBo articleBo);
	int likeArticle(ArticleDto articleDto);
	List<ArticleDto> getArticles();
}
