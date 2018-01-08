package com.vduty.vbackstage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;

@ServletComponentScan
@ComponentScan(basePackages ="com.vduty.vbackstage")
@SpringBootApplication
@MapperScan("com.vduty.vbackstage.**.mapper") 
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class VBackstageApplication  extends SpringBootServletInitializer {
 
	static Logger logger = LogManager.getLogger(VBackstageApplication.class);  
		
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

	   return (container -> {
	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
	        ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/403.html");
	        

	        container.addErrorPages(error401Page, error404Page, error500Page,error403Page);
	   });
	}
	
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(VBackstageApplication.class);
	    }
	
	public static void main(String[] args) {		
		SpringApplication.run(VBackstageApplication.class, args);
		logger.info("VBackstage  runing...");
				
	}
}
