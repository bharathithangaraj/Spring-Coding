//package com.unimoni.spring.cloud.hystrix.rest.consumer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ZipkinConfig {
//
//  @Autowired
//  private SpanMetricReporter spanMetricReporter;
//
//  @Autowired
//  private ZipkinProperties zipkinProperties;
//  @Value("${spring.sleuth.web.skipPattern}")
//  private String skipPattern;
//
//  public static void main(String[] args) {
//    SpringApplication.run(BookServiceApplication.class, args);
//  }
//
//  @Bean
//  public ZipkinSpanReporter makeZipkinSpanReporter() {
//    return new ZipkinSpanReporter() {
//      private HttpZipkinSpanReporter delegate;
//      private String baseUrl;
//
//      @Override
//      public void report(Span span) {
//        InstanceInfo instance = eurekaClient.getNextServerFromEureka("zipkin", false);
//        if (!(baseUrl != null && instance.getHomePageUrl().equals(baseUrl))) {
//          baseUrl = instance.getHomePageUrl();
//          delegate = new HttpZipkinSpanReporter(new RestTemplate(), baseUrl, zipkinProperties.getFlushInterval(), spanMetricReporter);
//          if (!span.name.matches(skipPattern)) delegate.report(span);
//        }
//      }
//    };
//  }
//}
