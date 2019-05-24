package com.unimoni.spring.cloud.hystrix.rest.consumer;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.reporters.RemoteReporter;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.jaegertracing.spi.Reporter;
import io.jaegertracing.spi.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class RestConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }
}

//@ConditionalOnProperty(value = "opentracing.jaeger.enabled", havingValue = "false", matchIfMissing = false)
//@Configuration
//public class MyTracerConfiguration {
//
//    @Bean
//    public io.opentracing.Tracer jaegerTracer() {
//        final Reporter reporter = new RemoteReporter.Builder().withSender(s)
//        final Sampler sampler = new ConstSampler(true);
//        return new JaegerTracer.Builder("untraced-service")
//            .withReporter(reporter)
//            .withSampler(sampler)
//            .build();
//    }
//}