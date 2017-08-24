package com.gaebalja.biz.trace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.gaebalja.biz.trace.model.Trace;
import com.gaebalja.biz.trace.repository.TraceLogRepository;
import com.gaebalja.common.DateUtils;

//@Service
public class TraceLogServiceByRepository {
	
	@Autowired
	private TraceLogRepository traceLogRepository;
	
	public Trace save(Trace trace){
		trace.setId(String.valueOf(trace.getTimestamp()));
		trace.setAuthor(trace.getInfo().getAuthor());
		trace.setDate(DateUtils.getToday("yyyy-MM-dd HH:mm:ss:SSS"));
//		trace.setDate(new Date());
		return traceLogRepository.save(trace);
	}
	
	public Trace findById(String id){
		return traceLogRepository.findOne(id);
	}
	
	public void delete(Trace trace){
		traceLogRepository.delete(trace);
	}
	
	public Iterable<Trace> findAll(){
		return traceLogRepository.findAll();
	}
	
	public Page<Trace> findByAuthor(String author, PageRequest pageRequest){
		return traceLogRepository.findByAuthor(author, pageRequest);
	}
	
}
