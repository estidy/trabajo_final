package com.cervelBuenTrato.core.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry register) {
		// register.addViewController("/").setViewName("index");
		register.addViewController("/templates_errors/403").setViewName("/templates_errors/403");
	}
}
