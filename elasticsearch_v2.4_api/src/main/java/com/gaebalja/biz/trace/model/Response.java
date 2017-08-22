package com.gaebalja.biz.trace.model;

public class Response {
	
	private String XApplicationContext;
	private String ContentType;
	private String TransferEncoding;
	private String Date;
	private String status;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" XApplicationContext=").append(XApplicationContext)
				.append(", ContentType=").append(ContentType).append(", TransferEncoding=").append(TransferEncoding)
				.append(", Date=").append(Date).append(", status=").append(status);
		return builder.toString();
	}
}
