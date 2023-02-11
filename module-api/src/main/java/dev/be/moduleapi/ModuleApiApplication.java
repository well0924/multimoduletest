package dev.be.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"dev.be.modulecommon","dev.be.moduleapi"})
@EntityScan("dev.be.modulecommon.domain")
@EnableJpaRepositories(basePackages = "dev.be.modulecommon.repository")
public class ModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApiApplication.class, args);
	}

}
