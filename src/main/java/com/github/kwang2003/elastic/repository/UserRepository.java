package com.github.kwang2003.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.github.kwang2003.elastic.bean.User;

public interface UserRepository extends ElasticsearchRepository<User, String> {

}
