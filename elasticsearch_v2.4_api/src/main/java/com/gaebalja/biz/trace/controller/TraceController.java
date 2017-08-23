package com.gaebalja.biz.trace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebalja.biz.trace.model.Trace;
import com.gaebalja.biz.trace.service.TraceService;

@RestController
@RequestMapping(value= "/trace", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TraceController {
	
	@Autowired
	private TraceService traceService;
	
//	@Async
	@PostMapping("/save")
	public Trace save(@RequestBody Trace trace){
		System.out.println(trace.toString());
		trace.setId(String.valueOf(trace.getTimestamp()));
		trace.setAuthor(trace.getInfo().getAuthor());
		return traceService.save(trace); 
	}
}
