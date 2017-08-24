package com.gaebalja.biz.trace;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
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

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TraceElasticsearchTemplateSearchTest {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void countTest(){
	    CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria());  
	    long count = elasticsearchTemplate.count(criteriaQuery, Trace.class);
	    System.out.println("countTest = " + count);
	}
	
	@Test
	public void countTest2(){
	    SearchQuery searchQuery = new NativeSearchQueryBuilder()
	    		.withQuery(matchAllQuery())
	    		.withIndices("es_index")
	    	    .withTypes("trace")
	    	    .build();
	    long count = elasticsearchTemplate.count(searchQuery, Trace.class);
	    System.out.println("countTest2 = " + count);
	}
	
	@Test
	public void getTracePage(){
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
	    		.withQuery(matchAllQuery())
	    		.withIndices("es_index")
	    	    .withTypes("trace")
	    	    .withSort(new FieldSortBuilder("timestamp").order(SortOrder.DESC))
	    	    .withPageable(new PageRequest(0, 5))
	    	    .build();
		
	    Page<Trace> traces = elasticsearchTemplate.queryForPage(searchQuery, Trace.class);
	    
	    String str = traces.getContent().stream()
	      .map(i -> i.toString())
	      .collect(Collectors.joining("\n"));
	    
	    System.out.println(">>>"+ str);
	    System.out.println(">>>"+ traces.getContent().size());
	}
	
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
