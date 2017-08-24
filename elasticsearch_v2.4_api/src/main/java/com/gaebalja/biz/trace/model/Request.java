package com.gaebalja.biz.trace.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
	private String host;
	private String connection;
	@JsonProperty("content-length")
	private String contentLength;
	@JsonProperty("cache-control")
	private String cacheControl;
	
	@JsonProperty("user-agent")
	private String userAgent;
	@JsonProperty("content-type")
	private String contentType;
	private String accept;
	@JsonProperty("accept-encoding")
	private String acceptEncoding;
	@JsonProperty("accept-language")
	private String acceptLanguage;
	private String cookie;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	public String getCacheControl() {
		return cacheControl;
	}

	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

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
