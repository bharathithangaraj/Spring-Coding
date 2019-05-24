package com.unimoni.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.unimoni.model.Cibil;

@Service
public class CibilService {

	Set<Cibil> data = new HashSet<>();

	public void addData() {
		Cibil c1 = new Cibil("P1", 400, "A1");
		Cibil c2 = new Cibil("P2", 450, "A2");
		data.add(c1);
		data.add(c2);
	}

	public Optional<Cibil> findCibilScore(String aadher) {
		addData();
		Optional<Cibil> cibil = data.stream().filter(c -> c.getAadher().equals(aadher)).findFirst();
		return cibil;
	}

	public Set<Cibil> saveCibil(Cibil cibil) {
		if(data.size()==0) {
			addData();
		}
		data.add(cibil);
		return data;
	}

}
