package com.testproject.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = { "com.testproject.springmvc" }, excludeFilters = {
		@ComponentScan.Filter(pattern= "com.testproject.springmvc.web.*", type = FilterType.REGEX)})
@EnableAspectJAutoProxy
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig
{

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
