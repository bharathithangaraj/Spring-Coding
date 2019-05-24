package com.junit.assertions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAnyElement;

@Entity
public class Device {
@Id
@GeneratedValue
private String deviceNo;
private String deviceName;
private String ownerName;

public Device() {}

public Device(String deviceNo, String deviceName, String ownerName) {
	super();
	this.deviceNo = deviceNo;
	this.deviceName = deviceName;
	this.ownerName = ownerName;
}

@XmlAnyElement
public String getDeviceNo() {
	return deviceNo;
}

public void setDeviceNo(String deviceNo) {
	this.deviceNo = deviceNo;
}

@XmlAnyElement
public String getDeviceName() {
	return deviceName;
}

public void setDeviceName(String deviceName) {
	this.deviceName = deviceName;
}

@XmlAnyElement
public String getOwnerName() {
	return ownerName;
}

public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}

@Override
public String toString() {
	return "Device [deviceName=" + deviceName + ", ownerName=" + ownerName + "]";
}

}


