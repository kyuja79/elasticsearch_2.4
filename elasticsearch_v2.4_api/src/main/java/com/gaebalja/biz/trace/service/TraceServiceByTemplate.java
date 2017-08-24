package com.gaebalja.biz.trace.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

import com.gaebalja.biz.trace.model.Trace;
import com.gaebalja.common.DateUtils;

@Service
public class TraceServiceByTemplate {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@PostConstruct
	public void init(){
        try {
        	String traceIndex = "ex_index_trace-"+DateUtils.getToday("yyyy-MM-dd");
            if (!elasticsearchTemplate.indexExists(traceIndex)) {    
                elasticsearchTemplate.createIndex(traceIndex);    
            }
            // settings
            // TODO : kyuja --> settings
            
            // mappings
			elasticsearchTemplate.putMapping(traceIndex, "trace", getMapping());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	private XContentBuilder getMapping() throws IOException{
/*
{
	"mappings": {
		"trace": {
			"properties": {
				"date": {
					"format": "yyyy-MM-dd HH:mm:ss:SSS",
					"type": "date"
				},
				"author": {
					"type": "string"
				},
				"id": {
					"type": "string"
				},
				"info": {
					"properties": {
						"headers": {
							"properties": {
								"request": {
									"properties": {
										"accept-language": {
											"type": "string"
										},
										"cookie": {
											"type": "string"
										},
										"host": {
											"type": "string"
										},
										"connection": {
											"type": "string"
										},
										"content-type": {
											"type": "string"
										},
										"cache-control": {
											"type": "string"
										},
										"accept-encoding": {
											"type": "string"
										},
										"accept": {
											"type": "string"
										},
										"user-agent": {
											"type": "string"
										}
									}
								},
								"response": {
									"properties": {
										"contentLength": {
											"type": "string"
										},
										"Content-Length": {
											"type": "string"
										},
										"X-Application-Context": {
											"type": "string"
										},
										"contentType": {
											"type": "string"
										},
										"Content-Type": {
											"type": "string"
										},
										"status": {
											"type": "string"
										},
										"xapplicationContext": {
											"type": "string"
										}
									}
								}
							}
						},
						"path": {
							"type": "string"
						},
						"method": {
							"type": "string"
						},
						"author": {
							"type": "string"
						}
					}
				},
				"timestamp": {
					"type": "long"
				}
			}
		}
	}
}
*/
		XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
		xContentBuilder
			.startObject()
				.startObject("trace")
					.startObject("properties")
						.startObject("date")
							.field("format", "yyyy-MM-dd HH:mm:ss:SSS")
							.field("type" , "date")
						.endObject()
						.startObject("author")
							.field("type" , "string")
						.endObject()					
					.endObject()
				.endObject()
			.endObject();
		return xContentBuilder; 
	}
	
	public String save(Trace trace){
		trace.setId(String.valueOf(trace.getTimestamp()));
		trace.setAuthor(trace.getInfo().getAuthor());
		trace.setDate(DateUtils.getToday("yyyy-MM-dd HH:mm:ss:SSS"));
		IndexQuery indexQuery = new IndexQuery();
	    indexQuery.setIndexName("ex_index_trace-"+DateUtils.getToday("yyyy-MM-dd"));
	    indexQuery.setType("trace");
	    
/*
{
	"_index": "ex_index_trace-2017-08-24",
	"_type": "trace",
	"_id": "1503554827711",
	"_version": 1,
	"_score": 1,
	"_source": {
		"id": "1503554827711",
		"timestamp": 1503554827711,
		"author": "primeapi",
		"info": {
			"author": "primeapi",
			"method": "GET",
			"path": "/product/selectProdInfoCount/-1",
			"headers": {
				"request": {
					"host": "localhost:19999",
					"connection": "keep-alive",
					"accept": "*\/*",
					"cookie": "SCOUTER=z24uncisokv2gk; ssocioAdmin=7ynRsgxqC4Vk1U3+KJhEVQQu7geRylt+o1Yz4AfGR07VVRaScVshwkhF5KUFOR2hYCfLf9KMXEGbhJEWlQMOQb3uyGw++U0VXRWeBZmy9Bdgg+5NxWjmNWVlZX113K5At/cya95kPRHhcnGBI8cq5HXqhElqVLaxMqjIEtIxyW6acU05g0lj0p6KRBkOb0HdDP+/kycj3OhX/+AxAFSpSL9N2eh2uUfMJvyqDZNqeotc2eCDKjnJkNTNNeNAhL6ie993wfOuC65XxaE/wcN3Gw63LjTp5CFJidGutOClb1PW7ADrDHf3nU5Z0psMFWFtiCHLbw1uRJV9lMrhq8XHabSNqGjsqTQljIo45T/kAF0EcmHbQ5qvNq9QwHQdN3zpY4cSgitiri6hGVtJ71bD0Cunh0dt4SdIUKh866bgGQ9EL+6LbuDzUw29XCYYWuhrL0YGRsfNZD4tBLhXY1PBuexMboCNY9jf9R0q30yY4dOBZrcza75zzq5O2elIA0QQQUljWXEMswYgOyFgOwkUipPoglpsstm/tNY+BJ7kj4L1jNn4tQi70s/sxXJiq9aqYY0cQvw892+Hz3L51oPgDAdBU1Kh0ZStdEQkVLiQCoJctScz+AlMXC/VJmwiQuz8",
					"content-length": null,
					"cache-control": "no-cache",
					"user-agent": "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36",
					"content-type": "application/json;charset=utf-8",
					"accept-encoding": "gzip, deflate, br",
					"accept-language": "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4"
				},
				"response": {
					"status": "200",
					"date": null,
					"contentLength": "3",
					"contentType": "application/json;charset=UTF-8",
					"xapplicationContext": "application:19999",
					"transferEncoding": null,
					"X-Application-Context": "application:19999",
					"Content-Type": "application/json;charset=UTF-8",
					"Transfer-Encoding": null,
					"Content-Length": "3"
				}
			}
		},
		"date": "2017-08-24 15:07:07:714"
	}
}	    
 */
	    indexQuery.setObject(trace);
	    String index = elasticsearchTemplate.index(indexQuery);
		return index;
	}
	
}
