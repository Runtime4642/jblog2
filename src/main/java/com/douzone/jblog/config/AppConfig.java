package com.douzone.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.douzone.jblog.config.app.DBConfig;
import com.douzone.jblog.config.app.MyBatisConfig;


@Configuration
@EnableAspectJAutoProxy //AOP
@ComponentScan(value= {"com.douzone.jblog.repository","com.douzone.jblog.service","com.douzone.jblog.aspect"})
@Import(value= {DBConfig.class,MyBatisConfig.class})
public class AppConfig {
	

}
