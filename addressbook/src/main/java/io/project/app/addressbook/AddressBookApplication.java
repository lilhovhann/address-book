package io.project.app.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = {"io.project.app.addressbook"})
@EnableMongoRepositories("io.project.app.addressbook.repositories")
@EntityScan("io.project.app.addressbook.domain")
@EnableAsync
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

}
