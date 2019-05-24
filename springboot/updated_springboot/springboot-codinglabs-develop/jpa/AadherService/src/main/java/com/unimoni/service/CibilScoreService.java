package com.unimoni.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.unimoni.request.Cibil;
import com.unimoni.response.CibilResponse;

/**
 * 
 * @author gopi
 *
 */
@Service
public class CibilScoreService {

	public String cibilServiceUrl = "http://localhost:8081/cibil/";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RestTemplate template2;

	public CibilResponse getCibilScore(String aadher) {
		String url = cibilServiceUrl + aadher;
		System.out.println(restTemplate.hashCode());
			ResponseEntity<CibilResponse> response = restTemplate.exchange(url, HttpMethod.GET, null,
					CibilResponse.class);
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
		ResponseEntity<Set> response = restTemplate.exchange(cibilServiceUrl, HttpMethod.POST, entity, Set.class);
		return response.getBody();
	}

}
