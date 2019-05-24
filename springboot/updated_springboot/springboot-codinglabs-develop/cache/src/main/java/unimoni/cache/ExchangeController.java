package unimoni.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unimoni.cache.service.ExchangeRateService;

import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

  @Autowired
  ExchangeRateService rateService;

  @GetMapping("/{code}")
  public Map getExchangeRate(@PathVariable("code") String currencyCode) {
    Map result = new HashMap<>();

    // query the service
    result.put(currencyCode, rateService.findExchangeRate(currencyCode));
    return result;
  }

  @DeleteMapping("/{code}")
  public void reset(@PathVariable("code") String currencyCode){
    rateService.deleteRate(currencyCode);
  }

  @PostMapping("/{code}/{rate}")
  public void newRate(@PathVariable("code") String currencyCode, @PathVariable Double rate){
    rateService.addRate(currencyCode,rate);
  }
}
