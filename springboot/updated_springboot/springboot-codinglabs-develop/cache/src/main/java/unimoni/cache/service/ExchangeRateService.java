package unimoni.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ExchangeRateService {

  Logger logger = LoggerFactory.getLogger(ExchangeRateService.class);

  List<String> currencies = Currency.getAvailableCurrencies().stream().map(i -> i.getCurrencyCode()).collect(Collectors.toList());


  Random random = new Random();
  static final String cacheName = "exchange_rate";

  @Cacheable(cacheNames = cacheName, key = "#code")
  public Double findExchangeRate(String code) {
    logger.info("Fetching the rate for code" + code);
    Double d = random.nextDouble();
    logger.info("Random Cache value " + d);
    return d;
  }

  @CacheEvict(cacheNames = cacheName, key = "#code")
  public void deleteRate(String code) {
  }

  @CachePut(cacheNames = cacheName, key = "#p0")  // 'code' =  #root.args[0] = #p0 = #a0
  public Double addRate(String code, Double value) {
    return value;
  }

}
