package com.rays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rays.common.FrontCtl;

/**
 * Rahul Kirar
 *
 */
@SpringBootApplication
public class ProjectOrsApplication extends SpringBootServletInitializer {

	@Autowired
	private Environment env;

	@Autowired
	FrontCtl frontCtl;

	public static void main(String[] args) {
		SpringApplication.run(ProjectOrsApplication.class, args);

	}

	/**
	 * Enables CORS to all urls (cross origin resource sharing)
	 * 
	 * @return
	 */
//	 @Bean is an annotation used in Spring Framework to indicate that a method instantiates,
//	 configures, and initializes a new object to be managed by the Spring container. Typically, 
//	 this annotation is used within classes annotated with @Configuration to define beans, which are
//	 essentially Spring-managed objects. Beans are the fundamental building blocks of a Spring application,
//	 and they are created and managed by the Spring IoC (Inversion of Control) container. The @Bean annotation 
//	 allows you to explicitly declare how beans should be created and configured within your Spring application.
	@Bean
	public WebMvcConfigurer corsConfigurer() {

		WebMvcConfigurer w = new WebMvcConfigurer() {

			/**
			 * Add CORS
			 * 
			 */
			public void addCorsMappings(CorsRegistry registry) {
				CorsRegistration cors = registry.addMapping("/**");//Cross-origin resource sharing (CORS)
				cors.allowedOrigins("http://localhost:4200");
//				cors.allowedHeaders("*");
				cors.allowedMethods("GET", "POST", "PUT", "DELETE");
				cors.allowCredentials(true);
			}
			
			//Cross-origin resource sharing (CORS)==>> is a browser security feature that restricts cross-origin HTTP 
			//requests that are initiated from scripts running in the browser.

			/**
			 * Add Interceptors
			 */

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns("/Auth/**" ,"/User/profilePic/**");
			}

			/*
			 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
			 * registry.addResourceHandler("/**").addResourceLocations("classpath:/public/")
			 * ; }
			 * 
			 */

		};

		return w;
	}

}
