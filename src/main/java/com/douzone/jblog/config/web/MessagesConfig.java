package com.douzone.jblog.config.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessagesConfig {
	
	@Bean
	public MessageSource messageSource() {
	
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("com/douzone/config/web/messages/messages_ko");
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;
	}

}
