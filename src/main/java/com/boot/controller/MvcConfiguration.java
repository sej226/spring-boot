package com.boot.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
// 컨트롤러에서 .html 로 이동위해서 추가
@Configuration
@EnableWebMvc 
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	@Bean 
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setPrefix("../resources/templates/"); 
		resolver.setSuffix(".html");
		return resolver; 
		} 
	
	@Override 
	public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer) { 
		configurer.enable();
		} 
	}

