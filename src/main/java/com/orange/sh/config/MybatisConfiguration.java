package com.orange.sh.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MybatisConfiguration {

	@Bean
	@Order(1)
	public PageHelper createPageHelper() {
		log.info("加载pageHelper插件");
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("reasonable","true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
