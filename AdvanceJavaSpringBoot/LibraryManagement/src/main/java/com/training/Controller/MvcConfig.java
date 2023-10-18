package com.training.Controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Config file for spring mvc.
 * @author komalsingh01
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.training")
public class MvcConfig implements WebMvcConfigurer{
	
	

}
