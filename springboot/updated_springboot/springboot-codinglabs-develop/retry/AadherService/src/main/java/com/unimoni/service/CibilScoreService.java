package com.unimoni.service;

import com.unimoni.request.Cibil;
import com.unimoni.response.CibilResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

/**
 * @author gopi
 */
@Service
public class CibilScoreService {

  public String cibilServiceUrl = "http://localhost:8081/cibil/";

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  RestTemplate template2;

  @Autowired
  RetryTemplate retryTemplate;

  public CibilResponse getCibilScore(String aadher) {
    String url = cibilServiceUrl + aadher;
    System.out.println("calling  cibil for score");
    ResponseEntity<CibilResponse> response = restTemplate.exchange(url, HttpMethod.GET, null,
        CibilResponse.class);
    System.out.println("response from cibil");
    return response.getBody();
  }

  public CibilResponse getCibilScore2(String aadher) {
    String url = cibilServiceUrl + aadher;
    System.out.println(restTemplate.hashCode());
    try {
      ResponseEntity<CibilResponse> response = template2.exchange(url, HttpMethod.GET, null, CibilResponse.class);
      return response.getBody();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      // e.printStackTrace();
    }
    return null;
  }

  public Set saveCibil(Cibil cibil) {
    HttpEntity<Cibil> entity = new HttpEntity<Cibil>(cibil);
//		retryTemplate.execute(
//				new RetryCallback<Object, RuntimeException>() {
//					@Override
//					public Object doWithRetry(RetryContext context) {
//						return null;
//					}
//				}
//		);
    ResponseEntity<Set> response = restTemplate.exchange(cibilServiceUrl, HttpMethod.POST, entity, Set.class);
    return response.getBody();
  }

}
