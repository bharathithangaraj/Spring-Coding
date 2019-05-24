package com.wt.jmockito.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
	private CalculationService calcService;

    public void setCalculatorService(CalculationService calcService){
       this.calcService = calcService;
    }
    
    public double add(double input1, double input2){
       return calcService.add(input1, input2);		
    }
    
}
