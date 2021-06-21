package com.anand.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.anand.bo.ArticleBo;
import com.anand.dto.ArticleDto;

public class ArticledDaoImpl implements ArticledDao {
	private JdbcTemplate jt;
	private static final String SQL_POST_ARTICLE = "INSERT INTO ARTICLE values(?,?,?,?,?)";
	private static final String SQL_LIKE_ARTICLE = "INSERT INTO LIKES values(?,?,?,?,?)";
	private static final String SQL_GET_ARTICLES = "SELECT * FROM ARTICLE";
	private static final String SQL_GET_USER_INFO = "SELECT FULLNAME , EMAIL FROM USER_ACCOUNT";
	private static final String SQL_CHECK_LIKE = "SELECT COUNT(LID) FROM LIKES WHERE READER = ? AND AID = ?";

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int postArticle(ArticleBo articleBo) {
		return jt.update(SQL_POST_ARTICLE, articleBo.getArticleSerialNumber()
				.trim(), articleBo.getArticleHead().trim(), articleBo
				.getArticleBody().trim(), articleBo.getEmail().trim(),
				articleBo.getPostArticleDate());

	}

	@Override
	public List<ArticleDto> getArticles() {

		final Map<String, String> userProfile = jt.query(SQL_GET_USER_INFO,
				new ResultSetExtractor<Map<String, String>>() {

					@Override
					public Map<String, String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Map<String, String> profiles = new HashMap<String, String>();
						while (rs.next()) {
							profiles.put(rs.getString(2), rs.getString(1));
						}
						return profiles;
					}
				});
		return jt.query(SQL_GET_ARTICLES,
				new ResultSetExtractor<List<ArticleDto>>() {
					@Override
					public List<ArticleDto> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<ArticleDto> articleList = new ArrayList<ArticleDto>();
						while (rs.next()) {
							ArticleDto articleDto = new ArticleDto();
							articleDto.setArticleSerialNumber(rs.getString(1));
							articleDto.setArticleHead(rs.getString(2));
							articleDto.setArticleBody(rs.getString(3));
							articleDto.setEmail(rs.getString(4));
							articleDto.setFullName(userProfile.get(articleDto
									.getEmail()));
							articleDto.setPostArticleDate(rs.getString(5)
									.substring(0, 11));
							articleList.add(articleDto);
						}
						return articleList;

					}
				});

	}

	@Override
	public int likeArticle(ArticleDto articleDto) {
		
		int val=jt.queryForInt(SQL_CHECK_LIKE, new Object[] {
				articleDto.getReader().trim(),
				articleDto.getArticleSerialNumber().trim() });
		System.out.println(val);
		if (val> 0) {
			return 0;
		} else {
			return jt.update(SQL_LIKE_ARTICLE, articleDto.getLikeSerialNumber()
					.trim(), articleDto.getArticleSerialNumber().trim(),
					articleDto.getAuthor().trim(), articleDto.getReader()
							.trim(), articleDto.getLikeArticleDate().trim());
		}

	}
}
