package com.unimoni;

import com.unimoni.exception.RestTemplateResponseErrorHandler;
import com.unimoni.service.RetryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableRetry
public class AadherServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AadherServiceApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
  }

  @Bean(name = "template2")
  public RestTemplate restTemplate2(RestTemplateBuilder builder) {
    return builder.setConnectTimeout(Duration.ofSeconds(3)).setReadTimeout(Duration.ofSeconds(4)).build();
  }

  @Bean
  public RetryTemplate retryTemplate() {
    RetryTemplate template = new RetryTemplate();

    TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
    policy.setTimeout(30000L);

    template.setRetryPolicy(policy);
    return template;
  }

}
