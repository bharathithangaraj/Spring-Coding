package com.wt.jmockito;

import static org.mockito.Mockito.doThrow;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wt.jmockito.service.CalculationService;
import com.wt.jmockito.service.Calculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionHandlingMockitoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	Calculator calculator;
	
	@MockBean
	CalculationService calcService;
	
	@Test(expected = RuntimeException.class)
	public void testAdd(){
	      //add the behavior to throw exception
	      doThrow(new RuntimeException("Add operation not implemented")).when(calcService).add(10.0,20.0);
	      Assert.assertEquals(calculator.add(10.0, 20.0),30.0,0);
	}
	
}

