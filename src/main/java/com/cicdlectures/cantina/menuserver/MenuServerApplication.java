package com.cicdlectures.cantina.menuserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cicdlectures.cantina.menuserver.storage.RefreshRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = RefreshRepositoryImpl.class)
public class MenuServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuServerApplication.class, args);
	}

}
