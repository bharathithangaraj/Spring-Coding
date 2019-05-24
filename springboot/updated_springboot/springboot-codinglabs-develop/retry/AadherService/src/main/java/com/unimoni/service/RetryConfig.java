package com.unimoni.service;

import org.springframework.stereotype.Service;

@Service("retryConfig")
public class RetryConfig {

  public int getMaxAttempts() {
    return 2;
  }

}
