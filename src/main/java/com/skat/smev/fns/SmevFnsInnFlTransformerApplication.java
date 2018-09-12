package com.skat.smev.fns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SmevFnsInnFlTransformerApplication extends SpringBootServletInitializer{

//	public static void main(String[] args) {
//		SpringApplication.run(SmevFnsTransformerApplication.class, args);
//	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SmevFnsInnFlTransformerApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SmevFnsInnFlTransformerApplication.class, args);
	}
}
