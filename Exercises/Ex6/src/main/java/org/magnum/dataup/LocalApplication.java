/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.magnum.dataup;

import javax.servlet.MultipartConfigElement;

import org.magnum.dataup.model.InMemoryVideoRepository;
import org.magnum.dataup.model.VideoRepository;
import org.magnum.dataup.users.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.MultiPartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// This annotation tells Spring to auto-wire your application
@EnableAutoConfiguration
// This annotation tells Spring that this class contains configuration
// information
// for the application.
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@ComponentScan
@Configuration
public class LocalApplication {

	// The entry point to the application.
	public static void main(String[] args) {
		// This call tells spring to launch the application and
		// use the configuration specified in LocalApplication to
		// configure the application's components.
		SpringApplication.run(LocalApplication.class, args);
	}

	// This configuration element adds the ability to accept multipart
	// requests to the web container.
	@Bean
    public MultipartConfigElement multipartConfigElement() {
		// Setup the application container to be accept multipart requests
		final MultiPartConfigFactory factory = new MultiPartConfigFactory();
		// Place upper bounds on the size of the requests to ensure that
		// clients don't abuse the web container by sending huge requests
		factory.setMaxFileSize("150MB");
		factory.setMaxRequestSize("150MB");

		// Return the configuration to setup multipart in the container
		return factory.createMultipartConfig();
	}
	
	@Bean
	public VideoRepository videoRepository(){
		return new InMemoryVideoRepository();
	}


}
