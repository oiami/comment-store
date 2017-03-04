package com.pattawan.springboottraining.commentstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages= {"com.pattawan.springboottraining"})
public class CommentStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentStoreApplication.class, args);
	}
}
