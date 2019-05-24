package com.junit.assertions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceRepository {
private static Map<String, Device> repository;
	
	public DeviceRepository() {
		init();
	}
	
	@PostConstruct
	private void init() {
		repository = new HashMap<String, Device>();
		repository.put("1", new Device("1", "MAC", "Wavelabs"));
		repository.put("2", new Device("2", "IBM PC2", "Wavelabs"));
	}
	
	@PreDestroy
	private void shutdown() {
		repository = null;
	}

	public Device getDevice(String deviceNo) {
		return repository.get(deviceNo);
	}
	
	public Device addDevice(Device device) {
		String deviceNo = repository.size()+1+"";
		repository.put(deviceNo, device);
		return device;
	}
	
	public Device updateDevice(Device device) {
		repository.put(device.getDeviceNo(), device);
		return device;
	}
 
    public void deleteDeice(String deviceNo) {
    	repository.remove(deviceNo);
    }
 
    public List<Device> getAllDevices() {
        Collection<Device> c = repository.values();
        List<Device> list = new ArrayList<Device>();
        list.addAll(c);
        return list;
    }
}
