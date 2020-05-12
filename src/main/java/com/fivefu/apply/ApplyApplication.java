package com.fivefu.apply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ApplyApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
        SpringApplication.run(ApplyApplication.class, args);
    }
	
	/**
	 * 继承SpringBootServletInitializer重写configure方法
	 * 去除默认Tomcat
	 * **/
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplyApplication.class);
    }
	
}
