package com.github.kwang2003.elastic.repository;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.kwang2003.elastic.bean.User;
import com.github.kwang2003.util.DemoApplicationTests;

import lombok.extern.slf4j.Slf4j;

/**
{
  "user": {
    "mappings": {
      "user": {
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
          }
        }
      }
    }
  }
}
 */
@Slf4j
public class UserRepositoryTest extends DemoApplicationTests{
	@Autowired
	private UserRepository userRepository;
	@Test
	public void test() throws IOException {
		User entity = new User();
		entity.setName("张三");
		entity.setAge(20);
		userRepository.index(entity);
		log.info("{}",entity.getId());
	}

}
