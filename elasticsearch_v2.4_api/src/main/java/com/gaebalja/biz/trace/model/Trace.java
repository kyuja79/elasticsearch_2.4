package com.gaebalja.biz.trace.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "es_index", type = "trace")
public class Trace {
	private long timestamp;
	private Info info;
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" timestamp=").append(timestamp).append(", info=").append(info);
		return builder.toString();
	}
}
