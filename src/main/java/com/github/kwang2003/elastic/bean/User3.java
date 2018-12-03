package com.github.kwang2003.elastic.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document(indexName = "user3-#{indexDailySuffix}")
public class User3 {
	@Id
	private String id;
	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
	private Date timestamp;
	private String name;
	private Integer age;
	@GeoPointField
	private GeoPoint location;
}
