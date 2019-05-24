package com.unimoni.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.stereotype.Component;

@Component("myRetryListener")
public class MyRetryListener implements RetryListener {
  private Logger logger = LoggerFactory.getLogger(MyRetryListener.class);

  @Override
  public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
    logger.info(" MyRetryListener in open ");
    return true;
  }

  @Override
  public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
    logger.info(" MyRetryListener in close ");
  }

  @Override
  public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
    logger.info(" MyRetryListener in onError ");
  }
}
