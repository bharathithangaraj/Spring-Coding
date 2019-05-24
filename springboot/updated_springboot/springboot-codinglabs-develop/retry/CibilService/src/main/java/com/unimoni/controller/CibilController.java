package com.unimoni.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimoni.model.Cibil;
import com.unimoni.service.CibilService;


/**
 * 
 * @author gopi
 *
 */
@RestController
public class CibilController {

	@Autowired
	CibilService cibilService;

	@RequestMapping("/cibil/{aadher}")
	public ResponseEntity<Cibil> getCibilScore(@PathVariable("aadher") String aadher) {
		Optional<Cibil> result = cibilService.findCibilScore(aadher);
	/*	long start = System.currentTimeMillis();
		try {
			Thread.sleep(7000l);
			long end = System.currentTimeMillis();
			System.out.println("Gap : " + (end - start));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		if (result.isPresent()) {
			return ResponseEntity.status(200).body(result.get());
		} else {
			return ResponseEntity.status(404).build();
		}

	}

	@PostMapping("/cibil")
	public ResponseEntity<Set<Cibil>> save(@RequestBody Cibil cibil) {
		return ResponseEntity.status(200).body(cibilService.saveCibil(cibil));

	}

}
