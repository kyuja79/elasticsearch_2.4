package com.gaebalja.config;

import java.util.Map;

import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.gaebalja.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ElasticsearchTest {
	
    @Autowired
    private ElasticsearchOperations es;
    
    @Test
    public void printElasticSearchInfo() {

        System.out.println("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("<--ElasticSearch--");
    }
	
}	
