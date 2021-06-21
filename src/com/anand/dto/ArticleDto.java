package com.anand.dto;

import java.io.Serializable;

public class ArticleDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fullName;
	private String email;
	private String articleHead;
	private String articleBody;
	private String articleSerialNumber;
	private String postArticleDate;
	private String likeArticleDate;
	private String reader;
	private String author;
	private String likeSerialNumber;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArticleHead() {
		return articleHead;
	}

	public void setArticleHead(String articleHead) {
		this.articleHead = articleHead;
	}

	public String getArticleBody() {
		return articleBody;
	}

	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}

	public String getArticleSerialNumber() {
		return articleSerialNumber;
	}

	public void setArticleSerialNumber(String articleSerialNumber) {
		this.articleSerialNumber = articleSerialNumber;
	}

	public String getPostArticleDate() {
		return postArticleDate;
	}

	public void setPostArticleDate(String postArticleDate) {
		this.postArticleDate = postArticleDate;
	}

	public String getLikeArticleDate() {
		return likeArticleDate;
	}

	public void setLikeArticleDate(String likeArticleDate) {
		this.likeArticleDate = likeArticleDate;
	}

	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLikeSerialNumber() {
		return likeSerialNumber;
	}

	public void setLikeSerialNumber(String likeSerialNumber) {
		this.likeSerialNumber = likeSerialNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleDto [articleBody=");
		builder.append(articleBody);
		builder.append(", articleHead=");
		builder.append(articleHead);
		builder.append(", articleSerialNumber=");
		builder.append(articleSerialNumber);
		builder.append(", author=");
		builder.append(author);
		builder.append(", email=");
		builder.append(email);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", likeArticleDate=");
		builder.append(likeArticleDate);
		builder.append(", likeSerialNumber=");
		builder.append(likeSerialNumber);
		builder.append(", postArticleDate=");
		builder.append(postArticleDate);
		builder.append(", reader=");
		builder.append(reader);
		builder.append("]");
		return builder.toString();
	}

}
