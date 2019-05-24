package com.wt.jmockito.springrunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wt.jmockito.repositories.NumbersRepository;
import com.wt.jmockito.service.NumberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberServiceSpringContextMockTest {
	@MockBean
	NumbersRepository numrepositoryMock;
	
	@Autowired
	NumberService numberServiceImpl;
	
	@Test
	public void testFindTheGreatestFromAllData() {
		when(numrepositoryMock.retrieveAllNumbers()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(24, numberServiceImpl.findMaximumValue());
	}
	
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(numrepositoryMock.retrieveAllNumbers()).thenReturn(new int[] { 15 });
		assertEquals(15, numberServiceImpl.findMaximumValue());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(numrepositoryMock.retrieveAllNumbers()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, numberServiceImpl.findMaximumValue());
	}
}
