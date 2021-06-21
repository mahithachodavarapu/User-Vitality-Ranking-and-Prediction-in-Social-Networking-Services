package com.anand.bo;

public class MessageBo {

	private String toEmail;
	private String fromEmail;
	private String subject;
	private String message;
	private String postDate;
	private String serialID;
	private String status;

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getSerialID() {
		return serialID;
	}

	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageBo [fromEmail=");
		builder.append(fromEmail);
		builder.append(", message=");
		builder.append(message);
		builder.append(", postDate=");
		builder.append(postDate);
		builder.append(", serialID=");
		builder.append(serialID);
		builder.append(", status=");
		builder.append(status);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", toEmail=");
		builder.append(toEmail);
		builder.append("]");
		return builder.toString();
	}

}
