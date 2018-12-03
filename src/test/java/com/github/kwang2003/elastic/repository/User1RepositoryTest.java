package com.github.kwang2003.elastic.repository;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.kwang2003.elastic.bean.User1;
import com.github.kwang2003.util.DemoApplicationTests;

import lombok.extern.slf4j.Slf4j;
/**
{
  "user1": {
    "mappings": {
      "user1": {
        "properties": {
          "age": {
            "type": "long"
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
public class User1RepositoryTest  extends DemoApplicationTests{
	@Autowired
	private User1Repository user1Repository;
	@Test
	public void test() throws IOException {
		User1 entity = new User1();
		entity.setName("张三");
		entity.setAge(20);
		user1Repository.index(entity);
		log.info("{}",entity.getId());
	}

}
