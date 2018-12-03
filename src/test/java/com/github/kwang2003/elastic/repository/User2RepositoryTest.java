package com.github.kwang2003.elastic.repository;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.kwang2003.elastic.bean.User2;
import com.github.kwang2003.util.DemoApplicationTests;

import lombok.extern.slf4j.Slf4j;

/**
{
  "user2": {
    "mappings": {
      "user2": {
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
public class User2RepositoryTest extends DemoApplicationTests {
	@Autowired
	private User2Repository user2Repository;
	@Test
	public void test() throws IOException {
		User2 entity = new User2();
		entity.setName("李四");
		entity.setAge(25);
		user2Repository.index(entity);
		log.info("{}",entity.getId());
	}

}
