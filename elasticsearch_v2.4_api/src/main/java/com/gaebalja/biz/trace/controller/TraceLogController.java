package com.gaebalja.biz.trace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebalja.biz.trace.model.Trace;
import com.gaebalja.biz.trace.service.TraceLogServiceByTemplate;

@RestController
@RequestMapping(value= "/trace", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TraceLogController {
	
	private static Logger logger = LoggerFactory.getLogger(TraceLogController.class);
			
	@Autowired 
	private TraceLogServiceByTemplate traceLogTempService;
	
//	@PostMapping("/save")
//	public Trace save(@RequestBody Trace trace){
//		return traceRepoService.save(trace);
//	}
	
	@Async
	@PostMapping("/save")
	public void save(@RequestBody Trace trace){
		String index = traceLogTempService.save(trace);
		logger.info("index" + index);
	}
	
}
