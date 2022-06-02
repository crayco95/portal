package com.portal;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;


@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	 private final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);
	    

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		/*
		 * =====================================
		 * INTERNAL APP STATIC RESOURCES
		 * -------------------------------------
		 * Recursos static que no cambian
		 * recurrentemente y que se alojan en el
		 * directorio interno del app
		 * =====================================
		 * 
		 */
		
		
		//PUBLIC RESOURCES
		registry.addResourceHandler("/resources/public/**")
		.addResourceLocations("classpath:/static/app_resources/public/")
		.setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS).cachePublic())
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
		
		
		
		
	}
	

}


