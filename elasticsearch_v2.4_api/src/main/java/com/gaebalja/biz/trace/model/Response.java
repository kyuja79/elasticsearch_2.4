package com.gaebalja.biz.trace.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty("X-Application-Context")
	private String XApplicationContext;
	@JsonProperty("Content-Type")
	private String ContentType;
	@JsonProperty("Transfer-Encoding")
	private String TransferEncoding;
	@JsonProperty("Content-Length")
	private String ContentLength;
	
	private String Date;
	private String status;
	
	public String getXApplicationContext() {
		return XApplicationContext;
	}

	public void setXApplicationContext(String xApplicationContext) {
		XApplicationContext = xApplicationContext;
	}

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public String getTransferEncoding() {
		return TransferEncoding;
	}

	public void setTransferEncoding(String transferEncoding) {
		TransferEncoding = transferEncoding;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getContentLength() {
		return ContentLength;
	}
	public void setContentLength(String contentLength) {
		ContentLength = contentLength;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" XApplicationContext=").append(XApplicationContext)
				.append(", ContentType=").append(ContentType).append(", TransferEncoding=").append(TransferEncoding)
				.append(", ContentLength=").append(ContentLength).append(", Date=").append(Date).append(", status=")
				.append(status);
		return builder.toString();
	}
}
