package com.gaebalja.biz.trace.model;

public class Info {
	
	public Info() {
	}
	
	public Info(String author, String method, String path, Headers headers) {
		this.author = author;
		this.method = method;
		this.path = path;
		this.headers = headers;
	}	
	
	private String author;
	private String method;
	private String path;
	private Headers headers;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Headers getHeaders() {
		return headers;
	}
	public void setHeaders(Headers headers) {
		this.headers = headers;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" author=").append(author).append(", method=").append(method)
				.append(", path=").append(path).append(", headers=").append(headers);
		return builder.toString();
	}
}
