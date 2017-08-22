package com.gaebalja.biz.trace.model;

public class Request {
	private String host;
	private String connection;
	private String contentLength;
	private String cacheControl;
	private String userAgent;
	private String contentType;
	private String accept;
	private String acceptEncoding;
	private String acceptLanguage;
	private String cookie;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" host=").append(host).append(", connection=").append(connection)
				.append(", contentLength=").append(contentLength).append(", cacheControl=").append(cacheControl)
				.append(", userAgent=").append(userAgent).append(", contentType=").append(contentType)
				.append(", accept=").append(accept).append(", acceptEncoding=").append(acceptEncoding)
				.append(", acceptLanguage=").append(acceptLanguage).append(", cookie=").append(cookie);
		return builder.toString();
	}
}
