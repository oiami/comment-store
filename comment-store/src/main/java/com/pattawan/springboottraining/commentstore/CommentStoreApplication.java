package com.pattawan.springboottraining.commentstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages= {"com.pattawan.springboottraining"})
@ImportResource(value={"classpath*:legacy-context.xml"})
public class CommentStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentStoreApplication.class, args);
	}
}
