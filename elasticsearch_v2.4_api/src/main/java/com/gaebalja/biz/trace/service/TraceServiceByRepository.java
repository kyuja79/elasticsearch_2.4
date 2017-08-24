package com.gaebalja.biz.trace.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gaebalja.biz.trace.model.Trace;
import com.gaebalja.biz.trace.repository.TraceRepository;
import com.gaebalja.common.DateUtils;

//@Service
public class TraceServiceByRepository {
	
	@Autowired
	private TraceRepository traceRepository;
	
	public Trace save(Trace trace){
		trace.setId(String.valueOf(trace.getTimestamp()));
		trace.setAuthor(trace.getInfo().getAuthor());
		trace.setDate(DateUtils.getToday("yyyy-MM-dd HH:mm:ss:SSS"));
//		trace.setDate(new Date());
		return traceRepository.save(trace);
	}
	
	public Trace findById(String id){
		return traceRepository.findOne(id);
	}
	
	public void delete(Trace trace){
		traceRepository.delete(trace);
	}
	
	public Iterable<Trace> findAll(){
		return traceRepository.findAll();
	}
	
	public Page<Trace> findByAuthor(String author, PageRequest pageRequest){
		return traceRepository.findByAuthor(author, pageRequest);
	}
	
}
