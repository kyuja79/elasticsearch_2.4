package com.gaebalja.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.gaebalja.biz")
@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repositories")
@PropertySource(value = { "classpath:application.properties" })
public class ElasticSearchClientConfig {
	
    @Value("${elasticsearch.host}")
    private String elasticsearch_host;

    @Value("${elasticsearch.port}")
    private int elasticsearch_port;

    @Value("${elasticsearch.clustername}")
    private String elasticsearch_clustername;
    
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
    	return new ElasticsearchTemplate(client());
    }    
    
    /**
     * https://www.elastic.co/guide/en/elasticsearch/client/java-api/2.4/transport-client.html
     * @return
     * @throws Exception
     */
    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", elasticsearch_host)
                .put("client.transport.sniff", true)
                .build();
        
        return TransportClient.builder()
                .settings(esSettings)
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticsearch_host), elasticsearch_port));
    }

    
}
