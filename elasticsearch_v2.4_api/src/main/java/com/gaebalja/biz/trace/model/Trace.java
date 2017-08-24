package com.gaebalja.biz.trace.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "es_index", type = "trace")
public class Trace {
	
	public Trace() {
	}
	public Trace(String id){
		this.id = id;
	}
	public Trace(String id, long timestamp, Info info){
		this.id = id;
		this.timestamp = timestamp;
//		this.author = author;
		this.info = info;
	}
	@Id
	private String id;
	private long timestamp;
	
	@Field(type = FieldType.String, store = true)
	private String author;	// 접근자
	private Info info;
	
	@Field( type = FieldType.Date, format = DateFormat.custom,  pattern = "yyyy-MM-dd HH:mm:ss:SSS", store = true)
	private String date;
	
//	private 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" id=").append(id).append(", timestamp=").append(timestamp)
				.append(", author=").append(author).append(", info=").append(info).append(", date=").append(date);
		return builder.toString();
	}
}
