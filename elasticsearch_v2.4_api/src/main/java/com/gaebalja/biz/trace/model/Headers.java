package com.gaebalja.biz.trace.model;

public class Headers {
	private Request request;
	private Response response;
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" request=").append(request).append(", response=").append(response);
		return builder.toString();
	}
}
