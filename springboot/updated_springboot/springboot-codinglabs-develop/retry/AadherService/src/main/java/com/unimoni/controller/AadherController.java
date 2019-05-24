package com.unimoni.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.unimoni.exception.AadharNotFoundException;
import com.unimoni.request.Cibil;
import com.unimoni.response.CibilResponse;
import com.unimoni.response.ErrorResponse;
import com.unimoni.service.CibilScoreService;

/**
 * 
 * @author gopi
 *
 */
@RestController
public class AadherController {

	@Autowired
	private CibilScoreService cbilService;

	int count = 0;

	private Logger logger = LoggerFactory.getLogger(AadherController.class);


	@Retryable(
			maxAttempts = 5,
			maxAttemptsExpression = "${cibil.score.retry.max-attempts}",
			backoff = @Backoff(
					delay = 1000,
					multiplier = 2,
					multiplierExpression = "#{@retryConfig.getMaxAttempts()}"
			),

			listeners = "myRetryListener"
	)
	@RequestMapping("aadher/cbilscore/{number}")
	public ResponseEntity<Object> findCibilScore(@PathVariable("number") String aadher) {
		logger.info("Attempt : " + (++count) +  " - in controller ");
		CibilResponse response = cbilService.getCibilScore(aadher);
		if (response == null) {
			ErrorResponse errorResponse = new ErrorResponse(1801, "Aadher number not exist");
			return ResponseEntity.status(404).body(errorResponse);
		}
		return ResponseEntity.status(200).body(response);
	}

	@RequestMapping("aadher/cbilscore2/{number}")
	public ResponseEntity<Object> findCibilScore2(@PathVariable("number") String aadher) {

		CibilResponse response = cbilService.getCibilScore2(aadher);
		if (response == null) {
			ErrorResponse errorResponse = new ErrorResponse(1801, "Aadher number not exist");
			return ResponseEntity.status(404).body(errorResponse);
		}
		return ResponseEntity.status(200).body(response);
	}

	@PostMapping("aadher/cbil")
	public ResponseEntity<Set<Cibil>> addPersonCbil(@RequestBody Cibil cibil) {
		return ResponseEntity.status(200).body(cbilService.saveCibil(cibil));
	}

	@ExceptionHandler(AadharNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleException(AadharNotFoundException ex, WebRequest request) {

		Map<String, Object> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("timestamp", System.currentTimeMillis());
		map.put("aadhernumber", request.getParameterValues("number"));
		map.put("code", new Integer(1801));
		map.put("error_type", "Business");
		return ResponseEntity.status(404).body(map);

	}

	@Recover
	public ResponseEntity recover() {
		count=0;
		System.out.println("In recovery");
		Map<String, Object> map = new HashMap<>();
		map.put("message", "After retrying also failed");
		return ResponseEntity.status(200).body(map);
	}

}
