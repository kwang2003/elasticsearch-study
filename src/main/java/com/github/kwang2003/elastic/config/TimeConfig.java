package com.github.kwang2003.elastic.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TimeConfig {
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public String indexDailySuffix() {
		return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
	}
}
