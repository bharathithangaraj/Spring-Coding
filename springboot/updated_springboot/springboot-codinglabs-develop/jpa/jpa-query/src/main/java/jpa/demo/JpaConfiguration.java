package jpa.demo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages= {"jpa.repo"})
@EntityScan(basePackages = {"jpa.entity"})
public interface JpaConfiguration {
}
