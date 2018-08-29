package com.cnam.project.projectcnam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@SpringBootApplication
@EnableJpaAuditing
public class ProjectCnamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCnamApplication.class, args);
	}
}
