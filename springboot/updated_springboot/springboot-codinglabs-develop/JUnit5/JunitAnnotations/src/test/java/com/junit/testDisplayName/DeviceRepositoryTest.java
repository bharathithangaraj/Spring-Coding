package com.junit.testDisplayName;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit.assertions.Device;
import com.junit.assertions.DeviceRepository;
@DisplayName("This method is going to test the Product class")
class DeviceRepositoryTest {

private DeviceRepository deviceRepo;

@DisplayName("This method is going to test the our Test method")
	@Test
	public void testGetDevice() {
		deviceRepo = new DeviceRepository();
		
		Device d2 = new Device("5","Mac","");
		deviceRepo.addDevice(d2);
		Device d2copy = deviceRepo.getDevice("5");
		assertNotSame(d2copy,d2);
	}
@DisplayName("This method is going to test the our Test method")
	@Test
	public void testAddDevice() {
		DeviceRepository deviceRepo = new DeviceRepository();
		
		Device d1 = deviceRepo.addDevice(new Device("5","Mac",""));
		
		assertEquals(d1.getDeviceName(), "Mac");
	}

}



