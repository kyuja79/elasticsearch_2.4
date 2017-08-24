package com.gaebalja.biz.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gaebalja.Application;
import com.gaebalja.biz.trace.model.Headers;
import com.gaebalja.biz.trace.model.Info;
import com.gaebalja.biz.trace.model.Request;
import com.gaebalja.biz.trace.model.Response;
import com.gaebalja.biz.trace.model.Trace;
import com.gaebalja.biz.trace.service.TraceServiceByRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TraceServiceTest {
	
	/*
	@Autowired private TraceServiceByRepository traceService;
	
	@Before
	public void saveBefore(){
		Request req = new Request();
		
		req.setHost("localhost:20061");
		req.setConnection("keep-alive");
		req.setContentLength("73");
		req.setCacheControl("no-cache");
		req.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
		req.setContentType("application/json");
		req.setAcceptEncoding("gzip, deflate, br");
		req.setAcceptLanguage("ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
		req.setCookie("SCOUTER=z24uncisokv2gk; ssocioAdmin=7ynRsgxqC4Vk1U3+KJhEVQQu7geRylt+o1Yz4AfGR07VVRaScVshwkhF5KUFOR2hYCfLf9KMXEGbhJEWlQMOQb3uyGw++U0VXRWeBZmy9Bdgg+5NxWjmNWVlZX113K5At/cya95kPRHhcnGBI8cq5HXqhElqVLaxMqjIEtIxyW6acU05g0lj0p6KRBkOb0HdDP+/kycj3OhX/+AxAFSpSL9N2eh2uUfMJvyqDZNqeotc2eCDKjnJkNTNNeNAhL6ie993wfOuC65XxaE/wcN3Gw63LjTp5CFJidGutOClb1PW7ADrDHf3nU5Z0psMFWFtiCHLbw1uRJV9lMrhq8XHabSNqGjsqTQljIo45T/kAF0EcmHbQ5qvNq9QwHQdN3zpY4cSgitiri6hGVtJ71bD0Cunh0dt4SdIUKh866bgGQ9EL+6LbuDzUw29XCYYWuhrL0YGRsfNZD4tBLhXY1PBuexMboCNY9jf9R0q30yY4dOBZrcza75zzq5O2elIA0QQQUljWXEMswYgOyFgOwkUipPoglpsstm/tNY+BJ7kj4L1jNn4tQi70s/sxXJiq9aqYY0cQvw892+Hz3L51oPgDAdBU1Kh0ZStdEQkVLiQCoJctScz+AlMXC/VJmwiQuz8");
		
		Response resp = new Response();
		resp.setXApplicationContext("externalinterfaceapi:20061");
		resp.setContentType("application/json;charset=UTF-8");
		resp.setTransferEncoding("chunked");
		resp.setDate("Tue, 22 Aug 2017 01:46:05 GMT");
		resp.setStatus("200");
		Info info = new Info("ssocioapi", "POST", "/search/books", new Headers(req, resp));
		Trace trace = new Trace(String.valueOf(1503366365379L), 1503366365379L, info);
		Trace traceResult = traceService.save(trace);
		
		assertNotNull(traceResult.getId());
//		assertEquals(traceResult.getAuthor(), trace.getAuthor());
	}
	
	@Test
	public void findByIdTest(){
		
		Trace trace = new Trace(String.valueOf(1503366365379L));
		Trace findTrace = traceService.findById(trace.getId());
		
		assertNotNull(findTrace.getId());
		System.out.println(findTrace.toString());
	}
	
	*/
}
