package com.github.kwang2003.elastic.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "user")
public class User {
	@Id
	private String id;
	private Date timestamp;
	private String name;
	private Integer age;
}
