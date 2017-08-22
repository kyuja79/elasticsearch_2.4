package com.gaebalja.biz.trace.model;

public class Info {
	
	private String method;
	private String path;
	private Headers headers;
	
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
		builder.append(super.toString()).append(" method=").append(method).append(", path=").append(path)
				.append(", headers=").append(headers);
		return builder.toString();
	}
}
