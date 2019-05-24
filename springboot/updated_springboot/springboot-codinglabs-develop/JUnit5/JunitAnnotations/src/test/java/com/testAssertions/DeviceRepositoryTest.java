package com.testAssertions;

import static org.junit.Assert.*;
import org.junit.Test;

import com.junit.assertions.Device;
import com.junit.assertions.DeviceRepository;

public class DeviceRepositoryTest {

private DeviceRepository deviceRepo;
	
	@Test
	public void testGetDevice() {
		deviceRepo = new DeviceRepository();
		
		Device d2 = new Device("5","Mac","");
		deviceRepo.addDevice(d2);
		Device d2copy = deviceRepo.getDevice("5");
		assertNotSame(d2copy,d2);
	}

	@Test
	public void testAddDevice() {
		DeviceRepository deviceRepo = new DeviceRepository();
		
		Device d1 = deviceRepo.addDevice(new Device("5","Mac",""));
		
		assertEquals(d1.getDeviceName(), "Mac");
	}

}


