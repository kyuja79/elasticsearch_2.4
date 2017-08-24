package com.gaebalja.biz.trace;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.gaebalja.Application;
import com.gaebalja.biz.trace.model.Headers;
import com.gaebalja.biz.trace.model.Info;
import com.gaebalja.biz.trace.model.Request;
import com.gaebalja.biz.trace.model.Response;
import com.gaebalja.biz.trace.model.Trace;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TraceElasticsearchTemplateTest {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void saveTest(){
		Request req = new Request();
		
		req.setHost("localhost:20061");
		req.setConnection("keep-alive");
		req.setContentLength("73");
		req.setCacheControl("no-cache");
		req.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
		req.setAccept("*/*");
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
		Trace trace = new Trace(String.valueOf(1503394114168L), 1503394114168L, info);
		
		IndexQuery indexQuery = new IndexQuery();
	    indexQuery.setObject(trace);
	    indexQuery.setIndexName("trace-2017-08-24");
	    String index = elasticsearchTemplate.index(indexQuery);
	    
	    System.out.println("index = " + index);
		
	}
	
//	@Test
	public void updateTest() throws IOException {
		Request req = new Request();
		req.setHost("localhost:20061");
		req.setConnection("keep-alive");
		req.setContentLength("73");
		req.setCacheControl("no-cache");
		req.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
		req.setAccept("*/*");
		req.setContentType("application/json");
		req.setAcceptEncoding("gzip, deflate, br");
		req.setAcceptLanguage("ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
		req.setCookie("SCOUTER=z24uncisokv2gk; ssocioAdmin=7ynRsgxqC4Vk1U3+KJhEVQQu7geRylt+o1Yz4AfGR07VVRaScVshwkhF5KUFOR2hYCfLf9KMXEGbhJEWlQMOQb3uyGw++U0VXRWeBZmy9Bdgg+5NxWjmNWVlZX113K5At/cya95kPRHhcnGBI8cq5HXqhElqVLaxMqjIEtIxyW6acU05g0lj0p6KRBkOb0HdDP+/kycj3OhX/+AxAFSpSL9N2eh2uUfMJvyqDZNqeotc2eCDKjnJkNTNNeNAhL6ie993wfOuC65XxaE/wcN3Gw63LjTp5CFJidGutOClb1PW7ADrDHf3nU5Z0psMFWFtiCHLbw1uRJV9lMrhq8XHabSNqGjsqTQljIo45T/kAF0EcmHbQ5qvNq9QwHQdN3zpY4cSgitiri6hGVtJ71bD0Cunh0dt4SdIUKh866bgGQ9EL+6LbuDzUw29XCYYWuhrL0YGRsfNZD4tBLhXY1PBuexMboCNY9jf9R0q30yY4dOBZrcza75zzq5O2elIA0QQQUljWXEMswYgOyFgOwkUipPoglpsstm/tNY+BJ7kj4L1jNn4tQi70s/sxXJiq9aqYY0cQvw892+Hz3L51oPgDAdBU1Kh0ZStdEQkVLiQCoJctScz+AlMXC/VJmwiQuz8");
		Response resp = new Response();
		resp.setXApplicationContext("externalinterfaceapi:20061");
		resp.setContentType("application/json;charset=UTF-8");
		resp.setTransferEncoding("chunked");
		resp.setDate("Tue, 22 Aug 2017 01:46:05 GMT");
		resp.setStatus("300");
		Info info = new Info("ssocioapi", "GET", "/search/books", new Headers(req, resp));
		Trace trace = new Trace(String.valueOf(1503394114168L), 1503394114168L, info);
		
		IndexRequest indexRequest = new IndexRequest();
	    indexRequest.source(setXContentBuilder(trace));
		
	    UpdateQuery updateQuery = new UpdateQueryBuilder().withId("1503394114168")
	      .withClass(Trace.class).withIndexRequest(indexRequest).build();
	    
	    UpdateResponse update = elasticsearchTemplate.update(updateQuery);
	    System.out.println(update);
	}
	
//	@Test
	public void deleteTest() {
		String delete = elasticsearchTemplate.delete(Trace.class, "1503394114168");
	    System.out.println(delete);
	}
	
	
//	public void countTest(){
//	    SearchQuery searchQuery = new NativeSearchQueryBuilder()
//	    		.withQuery(matchAllQuery())
//	    		.withIndices("account")
//	    	    .withTypes("account")
//	    	    .build();
//	    long count = elasticsearchTemplate.count(searchQuery, Trace.class);
//	    System.out.println(count);
//	}
	
	
	private XContentBuilder setXContentBuilder(Trace trace) throws IOException{
		XContentBuilder builder = jsonBuilder()
				.startObject()
					.field("id", trace.getId())
					.field("timestamp", trace.getTimestamp())
					.startObject("info")
						.field("author", trace.getInfo().getAuthor())
						.field("method", trace.getInfo().getMethod())
						.field("path", trace.getInfo().getPath())
						.startObject("headers")
							.startObject("request")
								.field("host", trace.getInfo().getHeaders().getRequest().getHost())
								.field("connection", trace.getInfo().getHeaders().getRequest().getConnection())
								.field("contentLength", trace.getInfo().getHeaders().getRequest().getContentLength())
								.field("cacheControl", trace.getInfo().getHeaders().getRequest().getCacheControl())
								.field("userAgent", trace.getInfo().getHeaders().getRequest().getUserAgent())
								.field("contentType", trace.getInfo().getHeaders().getRequest().getContentType())
								.field("accept", trace.getInfo().getHeaders().getRequest().getAccept())
								.field("acceptEncoding", trace.getInfo().getHeaders().getRequest().getAcceptEncoding())
								.field("acceptLanguage", trace.getInfo().getHeaders().getRequest().getAcceptLanguage())
								.field("cookie", trace.getInfo().getHeaders().getRequest().getCookie())
							.endObject()
							.startObject("response")
								.field("XApplicationContext", trace.getInfo().getHeaders().getResponse().getXApplicationContext())
								.field("ContentType", trace.getInfo().getHeaders().getResponse().getContentType())
								.field("TransferEncoding", trace.getInfo().getHeaders().getResponse().getTransferEncoding())
								.field("Date", trace.getInfo().getHeaders().getResponse().getDate())
								.field("status", trace.getInfo().getHeaders().getResponse().getStatus())
							.endObject()
						.endObject()
					.endObject()
				.endObject();
		return builder;
	}
	
}
