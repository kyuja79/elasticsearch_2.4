package com.gaebalja.biz.trace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.gaebalja.biz.trace.model.Trace;

@Repository
public interface TraceRepository extends ElasticsearchRepository<Trace, String>{
	
	Page<Trace> findByAuthor(String author, Pageable pageable);
	
}
