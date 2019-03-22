package com.douzone.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.douzone.jblog.config.web.FileUploadConfig;
import com.douzone.jblog.config.web.MVCConfig;
import com.douzone.jblog.config.web.MessagesConfig;
import com.douzone.jblog.config.web.SecurityConfig;

@Configuration
@EnableAspectJAutoProxy //AOP
@EnableWebMvc   //<mvc:anntaion-driven/> 이랑 똑같음.. defaultservlethandler 랑 같음
@ComponentScan(value= {"com.douzone.jblog.controller","com.douzone.jblog.exception"})
@Import(value= {MVCConfig.class,SecurityConfig.class,MessagesConfig.class,FileUploadConfig.class})
public class WebConfig {

	
	
}
