package com.wt.jmockito.junitrunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.wt.jmockito.repositories.NumbersRepository;
import com.wt.jmockito.service.NumberService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NumberServiceMockTest {
	@Mock
	NumbersRepository numrepositoryMock;
	
	@InjectMocks
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
