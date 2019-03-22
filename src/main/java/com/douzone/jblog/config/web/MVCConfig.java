package com.douzone.jblog.config.web;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

//extends We~ 스프링에서 bean을 편하게 만들라고 미리만들어둠.
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter{
	
	// View Resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//보통 디폴트 서블릿을 설정해야 css 로 접근이 가능하다.
	//Falling Back On the DefaultServlet To Serve Resources
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	  configurer.enable();
	}
	
//	 예시
//	@Bean
//	public JsonConverter jsonConvert() {
//		return null;
//	}
	
	//Message Converters
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		  Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
				    .indentOutput(true)
				    .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
				    .modulesToInstall(new ParameterNamesModule());
		 
		  MappingJackson2HttpMessageConverter converter =  new MappingJackson2HttpMessageConverter(builder.build());
		  converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text","json",Charset.forName("utf-8"))));
		  
		  return converter;
	}
	//Message Converters
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text","html",Charset.forName("utf-8"))));
		
		return converter;
	}
	//Message Converters	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 예시 converters.add(jsonConvert());
		converters.add(stringHttpMessageConverter());
		converters.add(mappingJackson2HttpMessageConverter());
		
		
	}
	
	
	
	
}
