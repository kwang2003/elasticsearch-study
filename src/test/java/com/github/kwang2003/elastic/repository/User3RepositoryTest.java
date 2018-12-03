package com.github.kwang2003.elastic.repository;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import com.github.kwang2003.elastic.bean.User3;
import com.github.kwang2003.util.DemoApplicationTests;

import lombok.extern.slf4j.Slf4j;

/**
{
  "user3-2018.12.03": {
    "mappings": {
      "user3": {
        "properties": {
          "age": {
            "type": "long"
          },
          "location": {
            "type": "geo_point"
          },
          "name": {
            "type": "text",
            "fields": {
              "keyword": {
                "type": "keyword",
                "ignore_above": 256
              }
            }
          },
          "timestamp": {
            "type": "date",
            "store": true,
            "format": "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'"
          }
        }
      }
    }
  }
}
 *
 */
@Slf4j
public class User3RepositoryTest extends DemoApplicationTests {
	@Autowired
	private User3Repository user3Repository;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Test
	public void test() throws IOException {
		User3 entity = new User3();
		entity.setName("王晓2萌");
		entity.setAge(33);
		entity.setTimestamp(new Date());
		GeoPoint location = new GeoPoint(23.8878061038, 100.092612914d);
		entity.setLocation(location);
		user3Repository.index(entity);
		log.info("{}",entity.getId());
		
		Optional<User3> optional = user3Repository.findById(entity.getId());
		if(optional.isPresent()) {
			User3 user3 = optional.get();
			log.info("{}",user3);
		}
		
		log.info("{}",elasticsearchTemplate);
	}

}
