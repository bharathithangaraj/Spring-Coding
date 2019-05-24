package jpa.compositekey;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages= {"jpa.compositekey.idclass"})
@EntityScan(basePackages = {"jpa.compositekey.idclass"})
public interface JpaConfiguration {
}