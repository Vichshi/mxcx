package com.orange.sh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value= {"classpath:config.properties"})
@MapperScan("com.orange.sh.contract.mapper")
public class MxcxProApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MxcxProApplication.class, args);
	}
}
