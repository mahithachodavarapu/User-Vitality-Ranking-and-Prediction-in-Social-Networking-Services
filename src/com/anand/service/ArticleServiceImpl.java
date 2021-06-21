package com.anand.service;

import java.util.List;

import com.anand.bo.ArticleBo;
import com.anand.dao.ArticledDao;
import com.anand.dto.ArticleDto;
import com.anand.util.Utility;

public class ArticleServiceImpl implements ArticleService {
	private ArticledDao articledDao;
	private Utility utility;

	public void setArticledDao(ArticledDao articledDao) {
		this.articledDao = articledDao;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	@Override
	public String postArticle(ArticleDto articleDto) {
		ArticleBo articleBo = new ArticleBo();

		String message = null;
		try {
			articleBo.setEmail(articleDto.getEmail());
			articleBo.setArticleHead(articleDto.getArticleHead());
			articleBo.setArticleBody(articleDto.getArticleBody());
			articleBo.setEmail(articleDto.getEmail());

			articleBo.setArticleSerialNumber(utility.generateSerialNumber());
			articleBo.setPostArticleDate(utility.getCurrentDate());

			if (articledDao.postArticle(articleBo) >= 1) {
				message = "	<label style='color: green;'>Your post has been submitted </label>";
			} else {
				message = "	<label style='color: red;'>Sorry something went wrong, please try again </label>";
			}
		} catch (Exception e) {
			System.out.println(e);
			message = "	<label style='color: red;'>Sorry an unexpected error occurred please try again later </label>";
		}
		return message;
	}

	@Override
	public List<ArticleDto> getArticles() {
		return articledDao.getArticles();
	}

	@Override
	public String likeArticle(ArticleDto articleDto) {

		String message = null;
		articleDto.setLikeSerialNumber(utility.generateSerialNumber());
		try {
			articleDto.setLikeArticleDate(utility.getCurrentDate());			
			if (articledDao.likeArticle(articleDto)>= 1) {
				message = "	<label style='color: green;'>Thanks for like post</label>";
			} else {
				message = "	<label style='color: red;'>Sorry something went wrong, please try again </label>";
			}
			
		} catch (Exception e) {
			System.out.println(e);
			message = "	<label style='color: red;'>Sorry an unexpected error occurred please try again later </label>";
		
		}

		return message;
	}

}
