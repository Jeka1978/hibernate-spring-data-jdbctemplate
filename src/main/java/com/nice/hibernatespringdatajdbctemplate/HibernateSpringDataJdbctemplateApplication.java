package com.nice.hibernatespringdatajdbctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HibernateSpringDataJdbctemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run
				(HibernateSpringDataJdbctemplateApplication.class, args);
	}
}
